package effectivejava.item6;

import java.util.regex.Pattern;

public class isRomanNumeral {

    // performance can be greatly improved!
  /*  static boolean isRomanNumeral(String s){
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                        + "(X[CL]|L?X{0,3})(I[X,V]|V?I{0,3})$");
    }*/

  static boolean isRomanNumeral(String s){
      return ROMAN.matcher(s).matches();
  }

  // reusing expensive object for improved performance.
    public static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[X,V]|V?I{0,3})$");

    public static void main(String[] args) {
        String s ="a";
        System.out.println(isRomanNumeral(s));
    }
}
