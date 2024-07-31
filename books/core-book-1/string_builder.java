public class string_builder {
  public static void main(String[] args) {
    StringBuilder alph_builder = new StringBuilder();
    for (char ch = 'a'; ch != 'z' + 1; ++ch)
      alph_builder.append(ch);
    String alph = alph_builder.toString();
    System.out.println(alph);
  }
}
