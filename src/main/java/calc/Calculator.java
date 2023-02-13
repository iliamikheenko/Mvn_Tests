package calc;

public class Calculator {
    public int calculate(int first, int second, Operation operation){
        return switch (operation){
            case ADD -> first + second;
            case SUBTRACT -> first - second;
            case MULTIPLY -> first * second;
            case DIVIDE ->{
                if (second == 0) {
                    throw new IllegalArgumentException("It's forbidden to divide by 0");
                }
                yield first/second;
            }
        };
    }
}
