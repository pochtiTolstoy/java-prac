#include <ncurses.h>
#include <stdio.h>
#include <unistd.h>
#define DEAD_CELL '.'
#define CELL '0'
#define QUIT 'q'
#define INIT '?'
#define WIDTH 80
#define HEIGHT 25
#define FIELD_WIDTH 78
#define FIELD_HEIGHT 23
#define SPEED_1 1000000
#define SPEED_2 500000
#define SPEED_3 100000
#define SPEED_4 50000
#define SPEED_5 10000

void run_game_of_life(void);
void init_buffer(char buffer[][WIDTH], int rows, int cols);
void read_buffer(char buffer[][WIDTH], int rows, int cols);
void update_row_col(int *row, int *col, int cols);
void copy_buffer(char oldbuf[][WIDTH], char newbuf[][WIDTH], int rows, int cols);
void game_loop(char oldbuf[][WIDTH], char newbuf[][WIDTH], int rows, int cols);
void render_buffer(char newbuf[][WIDTH], int rows, int cols);
void update_buffer(char oldbuf[][WIDTH], char newbuf[][WIDTH], int rows, int cols);
int get_neighbours(char oldbuf[][WIDTH], int row, int col, int rows, int cols);
void update_cell(char oldbuf[][WIDTH], char newbuf[][WIDTH], int row, int col, int neighbours);
int is_alive(char oldbuf[][WIDTH], int row, int col, int rows, int cols);
void clear_screen(void);
void clear_buffer(void);
void init_curses(void);
int modulo(int num, int mod);
void update_speed(unsigned int *microseconds, char event);

int main(void) {
    run_game_of_life();
    return 0;
}

void run_game_of_life(void) {
    char newbuf[HEIGHT][WIDTH];
    char oldbuf[HEIGHT][WIDTH];
    init_buffer(newbuf, HEIGHT, WIDTH);
    init_buffer(oldbuf, HEIGHT, WIDTH);
    read_buffer(newbuf, HEIGHT, WIDTH);
    copy_buffer(oldbuf, newbuf, HEIGHT, WIDTH);
    game_loop(oldbuf, newbuf, HEIGHT, WIDTH);
}

void game_loop(char oldbuf[][WIDTH], char newbuf[][WIDTH], int rows, int cols) {
    char event = INIT;
    unsigned int microseconds = SPEED_1;
    init_curses();
    while (event != QUIT) {
        event = getch();
        render_buffer(newbuf, rows, cols);
        update_buffer(oldbuf, newbuf, rows, cols);
        copy_buffer(oldbuf, newbuf, rows, cols);
        update_speed(&microseconds, event);
        usleep(microseconds);
    }
    endwin();
}

void render_buffer(char newbuf[][WIDTH], int rows, int cols) {
    int row;
    int col;
    clear();
    for (row = 0; row < rows; ++row) {
        for (col = 0; col < cols; ++col) {
            addch(newbuf[row][col]);
        }
        addch('\n');
    }
    refresh();
}

void update_buffer(char oldbuf[][WIDTH], char newbuf[][WIDTH], int rows, int cols) {
    int neighbours;
    for (int row = 0; row < rows; ++row) {
        for (int col = 0; col < cols; ++col) {
            neighbours = get_neighbours(oldbuf, row, col, rows, cols);
            update_cell(oldbuf, newbuf, row, col, neighbours);
        }
    }
}

void init_buffer(char buffer[][WIDTH], int rows, int cols) {
    for (int row = 0; row < rows; ++row) {
        for (int col = 0; col < cols; ++col) {
            buffer[row][col] = INIT;
        }
    }
}

void read_buffer(char buffer[][WIDTH], int rows, int cols) {
    char symbol;
    int row = 0;
    int col = -1;
    while (scanf("%c", &symbol) == 1 && (symbol != '\0' && symbol != EOF)) {
        if (symbol == '\n') continue;
        update_row_col(&row, &col, cols);
        if (row >= rows || col >= cols) break;
        buffer[row][col] = symbol;
    }
}

void update_row_col(int *row, int *col, int cols) {
    if (*col == cols - 1) {
        *col = 0;
        ++*row;
    } else {
        ++*col;
    }
}

void copy_buffer(char oldbuf[][WIDTH], char newbuf[][WIDTH], int rows, int cols) {
    for (int row = 0; row < rows; ++row) {
        for (int col = 0; col < cols; ++col) {
            oldbuf[row][col] = newbuf[row][col];
        }
    }
}

int get_neighbours(char oldbuf[][WIDTH], int row, int col, int rows, int cols) {
    int count_neighbours = 0;
    for (int y = row - 1; y <= row + 1; ++y) {
        for (int x = col - 1; x <= col + 1; ++x) {
            if (x == col && y == row) continue;
            count_neighbours += is_alive(oldbuf, y, x, rows, cols);
        }
    }
    return count_neighbours;
}

void update_cell(char oldbuf[][WIDTH], char newbuf[][WIDTH], int row, int col, int neighbours) {
    switch (oldbuf[row][col]) {
        case CELL:
            newbuf[row][col] = (neighbours == 2 || neighbours == 3) ? CELL : DEAD_CELL;
            break;
        case DEAD_CELL:
            newbuf[row][col] = (neighbours == 3) ? CELL : DEAD_CELL;
            break;
        default:
            newbuf[row][col] = DEAD_CELL;
            break;
    }
}

void update_speed(unsigned int *microseconds, char event) {
    switch (event) {
        case '1':
            *microseconds = SPEED_1;
            break;
        case '2':
            *microseconds = SPEED_2;
            break;
        case '3':
            *microseconds = SPEED_3;
            break;
        case '4':
            *microseconds = SPEED_4;
            break;
        case '5':
            *microseconds = SPEED_5;
            break;
        default:
            break;
    }
}

int is_alive(char oldbuf[][WIDTH], int row, int col, int rows, int cols) {
    int correct_row = modulo(row, rows);
    int correct_col = modulo(col, cols);
    return (oldbuf[correct_row][correct_col] == CELL);
}

int modulo(int num, int mod) {
    if (mod == 0) return 0;
    int rem = num % mod;
    if (rem < 0) rem += mod;
    return rem;
}

void init_curses(void) {
    if (freopen("/dev/tty", "r", stdin)) initscr();
    curs_set(0);
    nodelay(stdscr, true);
}
