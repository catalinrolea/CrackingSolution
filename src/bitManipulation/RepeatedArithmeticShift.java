package bitManipulation;

public class RepeatedArithmeticShift {

    public static void main(String[] args)  {
        int count = 40;
        int x = -600;
        for (int i=0; i<count; i++) {
            x >>=3;//arithmetic shift by 1
            System.out.println(x);
        }

    }
}
