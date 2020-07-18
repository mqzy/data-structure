public class SparseArray {
    private static int[][] OriArray = new int[11][11];

    static void init(int[][] arr){
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[8][4] = 1;
    }

    private static void printArr(int[][] arr){
        for (int[] row:arr) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
    static int[][] to_Spa(int [][]arr){
        int sum = 0;
        for (int[] row:arr) {
            for (int data:row) {
                if (data != 0)
                    sum++;
            }
        }
        int[][] SpaArray = new int[sum+1][3];
        int row = 0;
        SpaArray[row] = new int[]{arr.length, arr[0].length, sum};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0){
                    row++;
                    SpaArray[row][0] = i;
                    SpaArray[row][1] = j;
                    SpaArray[row][2] = arr[i][j];
                }
            }
        }
        return SpaArray;
    }

    static int[][] to_Ori(int[][] arr){
        int[][] OriArray= new int[arr[0][0]][arr[0][1]];
        int row = 1;
        for (int i = 0; i < arr[0][2]; i++) {
            OriArray[arr[row][0]][arr[row][1]] = arr[row][2];
            row++;
        }
        return OriArray;
    }
    public static void main(String[] args) {
        init(OriArray);
        int[][] SA = to_Spa(OriArray);
//        printArr(SA);
        int[][] OA = to_Ori(SA);
        printArr(OA);
    }
}
