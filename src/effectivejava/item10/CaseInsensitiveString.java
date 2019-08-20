package effectivejava.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// broken violates symmetry contract of equals method.

// x y  x.equals(y) true , y.equals(x) true.. only it symmetry.

public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s){
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object obj) {
        //  voilates symmetry.
        if(obj instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
        if(obj instanceof String)
            return s.equalsIgnoreCase((String)obj);
        return false;

        // doesnt voilates symmetry.  to resolve above, remove interoperate with string. like below one return statement.
      // return obj instanceof CaseInsensitiveString && ((CaseInsensitiveString) obj).s.equalsIgnoreCase(s);

    }

    public static void main(String[] args) {

        CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString("Polish");
        CaseInsensitiveString caseInsensitiveString1 = new CaseInsensitiveString("Polish");

        String stringobj = "Polish";

        /*
        * voilates symmetry. class naively attempts to interoperate with ordinary strings. equals method this class
        * knows about ordinary string whereas equals method in the string class doesnt know. therefor it return false. a clear
        * violation of symmetry.
         */

        System.out.println("Object to String equals : " + caseInsensitiveString.equals(stringobj));
        System.out.println("String to Object equals : " + stringobj.equals(caseInsensitiveString));

       System.out.println("Object to Object equals : " + caseInsensitiveString.equals(caseInsensitiveString1));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(caseInsensitiveString);

        /*
        * Once equals contract is violated, we dont know how other objects will behave when confronted with your object.
        * */

        System.out.println("if object equals to string then list should contains right? but its not ! " +list.contains(stringobj));

       System.out.println("if object equals to Object then list should contains : " +list.contains(caseInsensitiveString1));

    }
}
