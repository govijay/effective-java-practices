package effectivejava.item11;

import java.util.Objects;

public class PhoneNumber1 {

    private final short areaCode,prefix,lineNum;

    public PhoneNumber1(int areaCode, int prefix, int lineNum){
        this.areaCode = rangeCheck(areaCode,999,"area code");
        this.prefix = rangeCheck(prefix,999,"prefix");
        this.lineNum = rangeCheck(lineNum,999,"line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if(val < 0 || val > max){
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short)val;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof PhoneNumber1))
            return false;
        PhoneNumber1 phoneNumber = (PhoneNumber1) obj;
        return phoneNumber.lineNum == lineNum && phoneNumber.prefix == prefix
                && phoneNumber.areaCode == areaCode;
    }

  /*  @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }*/

    @Override
    public int hashCode() {
        return  Objects.hash(lineNum,prefix,areaCode);
    }
}
