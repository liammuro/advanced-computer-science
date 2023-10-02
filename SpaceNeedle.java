
public class SpaceNeedle {
    final static int SIZE = 4; // When SIZE is changed, the height/width of the needle will also change.

    // Pre: none
    // Post: Prints out the needle portion
    public static void needle(int size) {
        for (int i = 1; i <= size; i++) {
            for (int space = 1; space <= size * 3; space++) {
                System.out.print(" ");
            }
            System.out.println("||");
        }
    }

    // Pre: none
    // Post: Prints out the upper dome half portion
    public static void upHalfDome(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = size - i; j > 1; j--) {
                System.out.print("   ");
            }
            
            System.out.print("__/");

            for (int j = i; j > 0; j--) {
                System.out.print(":::");
            }

            System.out.print("||");

            for (int j = i; j > 0; j--) {
                System.out.print(":::");
            }

            System.out.println("\\__");
        }
    }

    // Pre: none
    // Post: Prints out the spacer portion
    public static void spacer(int size) {
        System.out.print("|");
        for (int i = 0; i < size; i++) {
            System.out.print("\"\"\"\"\"\"");
        }
            System.out.println("|");
    }

    // Pre: none
    // Post: Prints out the bottom dome half portion
    public static void botHalfDome(int size) {
        for (int i = size; i > 0; i--) {
            for (int j = size - i; j > 0; j--) {
                System.out.print("  ");
            }
            System.out.print("\\_/");
            for (int j = size + 2 * (i - 1); j > 0; j--) {
                System.out.print("\\/");
            }
            System.out.println("\\_/");
        }
    }

    // Pre: none
    // Post: Prints out the body portion
    public static void body(int size) {
        for (int i = 0; i < size * size; i++) {
            for (int j = 0; j < size - 1; j++) {
                System.out.print("   ");
            }
            System.out.println("|%%||%%|");
        }
    }

    // Pre: none
    // Post: Prints out the full space needle by calling the respective methods
    // Takes an int parameter for size
    // size must be >=1, otherwise defaults to 1
    public static void printSpaceNeedle(int size) {
        if (size < 1) {
            System.out.println("illegal size: defaulting to size 1");
        }
        needle(size);
        upHalfDome(size);
        spacer(size);
        botHalfDome(size);
        needle(size);
        body(size);
        upHalfDome(size);
        spacer(size);

    }
    
    // Pre: none
    // Post: Prints out the full space needle by calling the printSpaceNeedle(int size) method
    // Passes the global int SIZE to printSpaceNeedle(int size)
    public static void printSpaceNeedle() {
        printSpaceNeedle(SIZE);
    }

    // Pre: none
    // Post: Tests the printSpaceNeedle(int size) method with a specified range range of sizes, min to max, inclusive
    // Takes two ints, min & max. If min > max or min < 1 defaults to size 1 
    public static void testSizes(int min, int max) {
        if (min > max || min < 1) {
            min = 1;
            max = 1;

            System.out.println("illegal min/max: defaulting to size 1");
        }
        for (int i = min; i <= max; i ++) {
            System.out.println("\n\nTesting size: " + i + "\n");
            printSpaceNeedle(i);
            
        }
    }

    public static void main(String[] args) {
        printSpaceNeedle();

        // testSizes(1, 4);
    }
}