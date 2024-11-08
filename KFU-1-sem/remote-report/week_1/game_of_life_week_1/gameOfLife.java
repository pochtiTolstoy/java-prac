import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;

class gameOfLife {
  static final int WIDTH = 80;
  static final int HEIGHT = 25;
  static final char INIT = '?';
  static final char CELL = '0';
  static final char DEAD_CELL = '.';
  static final char QUIT = 'q';

  public static void main(String[] args) {
    File file = getFile();
    if (file.exists()) {
      runGameOfLife(file);
    } else {
      System.out.printf("--Error: file not found.\n");
    }
  }

  static File getFile() {
    printMenu();
    Scanner scanner = new Scanner(System.in);
    String fileName = scanner.nextLine();
    File file = new File(fileName);
    //if (scanner.hasNextLine()) scanner.nextLine();
    scanner.close();
    return file;
  }

  static void printMenu() {
    System.out.printf("Welcome to game-of-life!\n\n");
    System.out.printf("Please enter file name with game-of-life map.\n");
    System.out.printf("Expected map parameters: width %d, height %d\n", WIDTH, HEIGHT);
    System.out.printf("Map should contain only two types of characters:\n");
    System.out.printf("  Character for live cell: %c\n", CELL);
    System.out.printf("  Character for dead cell: %c\n", DEAD_CELL);
    System.out.printf("Enter file name: ");
  }

  static void runGameOfLife(File file) {
    char[][] newbuf = new char[HEIGHT][WIDTH];
    char[][] oldbuf = new char[HEIGHT][WIDTH];
    initBuffer(newbuf);
    initBuffer(oldbuf);
    try {
      readBuffer(newbuf, file);
      copyBuffer(oldbuf, newbuf);
      gameLoop(oldbuf, newbuf);
    } catch (IOException error) {
      System.out.println("An error occures during input reading: " + error.getMessage());
    } catch (InterruptedException error) {
      System.out.println("An error occures during game loop: " + error.getMessage());
    }
  }

  static void gameLoop(char[][] oldbuf, char[][] newbuf) 
      throws InterruptedException {
    char event = INIT;
    //Scanner scanner = new Scanner(System.in);
    for(;;) {
      clearScreen();
      renderBuffer(newbuf); 
      updateBuffer(oldbuf, newbuf);
      copyBuffer(oldbuf, newbuf);
      //askCharacter();
      /*
      try {
        int input = System.in.read();
        event = (char) input;
      } catch (IOException error) {
        System.out.println("An error occures during input reading: " + error.getMessage());  
      }
      */
      Thread.sleep(100);
    }
    //scanner.close();
  }

  static void updateBuffer(char[][] oldbuf, char[][] newbuf) {
    int neighbours;
    int rows = oldbuf.length;
    int cols = oldbuf[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        neighbours = getNeighbours(oldbuf, row, col);
        updateCell(oldbuf, newbuf, row, col, neighbours);
      }
    }
  }

  static int getNeighbours(char[][] oldbuf, int row, int col) {
    int count_neighbours = 0; 
    for (int y = row - 1; y <= row + 1; ++y) {
      for (int x = col - 1; x <= col + 1; ++x) {
        if (x == col && y == row) continue;
        count_neighbours += isAlive(oldbuf, y, x);
      }
    }
    return count_neighbours;
  }

  static void updateCell(char[][] oldbuf, char[][] newbuf, int row, int col, int neighbours) {
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

  static int isAlive(char[][] oldbuf, int row, int col) {
    int correct_row = modulo(row, oldbuf.length);
    int correct_col = modulo(col, oldbuf[0].length);
    return (oldbuf[correct_row][correct_col] == CELL) ? 1 : 0;
  }

  static int modulo(int num, int mod) {
    if (mod == 0) return 0;
    int rem = num % mod;
    if (rem < 0) rem += mod;
    return rem;
  }

  static void askCharacter() { System.out.printf("Enter: "); }

  static void clearScreen() { System.out.printf("\033[H\033[J"); }

  static void initBuffer(char[][] buffer) {
    for (int row = 0; row < buffer.length; ++row) {
      for (int col = 0; col < buffer[row].length; ++col) {
        buffer[row][col] = INIT;
      }
    }
  }

  static void renderBuffer(char[][] buffer) {
    for (int row = 0; row < buffer.length; ++row) {
      for (int col = 0; col < buffer[row].length; ++col) {
        System.out.printf("%c", buffer[row][col]);
      }
      System.out.printf("\n");
    }
  }

  static void copyBuffer(char[][] oldbuf, char[][] newbuf) {
    for (int row = 0; row < newbuf.length; ++row) {
      for (int col = 0; col < newbuf[row].length; ++col) {
        oldbuf[row][col] = newbuf[row][col];
      }
    }
  }

  static void readBuffer(char[][] newbuf, File file) throws IOException {
    int row = 0;
    int col = -1;
    int cols = newbuf[0].length;
    int rows = newbuf.length;
    int symbolCode;
    FileReader fileReader = new FileReader(file);
  
    while ((symbolCode = fileReader.read()) != -1) {
      char character = (char) symbolCode;
      if (character == '\n') continue;
      int[] updatedRowCol = updateRowCol(row, col, cols);
      row = updatedRowCol[0];
      col = updatedRowCol[1];
      if (row >= rows || col >= cols) break;
      newbuf[row][col] = character;
    }
    fileReader.close();
  }

  static int[] updateRowCol(int row, int col, int cols) {
    if (col >= cols - 1) {
      col = 0;
      ++row;
    } else {
      ++col;
    }
    return new int[]{row, col};
  }
}
