import java.util.Arrays;


public class Peaks{


    public static int[] add(int n, int arr[], int x){
   
       
        int arr1[] = new int[n + 1];
        int i = 0;
        while (i < n){
            arr1[i] = arr[i];
            i += 1;
        }
        arr1[n] = x;
        return arr1;
    }

    public static int numPeaks(int[] data){
       
        int l = data.length;
        if (l == 0){
        
            System.out.println("Empty Array");
            return 0;
        }

        if (l == 1){
            return 1;
        }

        int i = 1;
        int count = 0;
        while (i < (l-1) ){

            if ((data[(i-1)] < data[i]) && (data[i] > data[(i+1)])){
                count += 1;
            }
            i += 1;
        }

        if (data[0] > data[1]){

            count += 1;
        }

        if (data[(l-2)] < data[(l-1)]){

            count +=1; 
        }
        return count;
    }


    public static int[] peaks(int[] data){
        // returns the locations of all peaks in the input data
        
        int[] p = {};
        int l = data.length;
        if (l == 0){
        
            System.out.println("Empty Array");
            return data;
        }

        if (l == 1){
            p = new int[] {0};
            return p;
        }

        if (data[0] > data[1]){

            p = add(0, p, 0);
        }

        int i = 1;
        while (i < (l-1) ){

            if ((data[(i-1)] < data[i]) && (data[i] > data[(i+1)])){
                
                int lp = p.length;
                p = add(lp, p, i);
            }
            i += 1;
        }
        if (data[(l-2)] < data[(l-1)]){

            int lp = p.length;
            p = add(lp, p, (l-1));
        }
        return p;
    }

    public static int max(int[] data){
        
        int l = data.length;
        int i = 0;
        int max = data[i];
        while (i < (l-1)){
            if (max < data[(i + 1)]){
                max = data[(i + 1)];
            }
            i += 1;
        }
        return max;
    }

    public static int min(int[] data){

        int l = data.length;
        int i = 0;
        int min = data[i];
        while (i < (l-1)){
            if (min > data[(i + 1)]){
                min = data[i + 1];
            }
            i += 1;
        }
        return min;
    }

    public static int[] arrmax(int[] data, int max){

        int l = data.length;
        int[] arrmax = {max};
        int i = 0;
        int m = 1;
        while (i < l){
            if (data[i] == max){
                arrmax = add(m, arrmax, i);
                m += 1;
            }
            i +=1;
        }
        return arrmax;
    }

    public static int[] arrmin(int[] data, int min){

        int l = data.length;
        int[] arrmin = {min};
        int i = 0;
        int n = 1;
        while (i < l){
            if (data[i] == min){
                arrmin = add(n, arrmin, i);
                n += 1;
            }
            i +=1;
        }
        return arrmin;
    }

    public static int[][] minmax(int[] data){
        // finds the min and max values (and all their locations)
        
        int[][] mm = {{},{}};
        int l = data.length;
        if (l == 0){
        
            System.out.println("Empty Array");
            return mm;
        }

        if (l == 1){
            mm = new int[][] {{data[0], 0}, {data[0], 0}};
            return mm;
        }

        int max = Peaks.max(data);
        int min = Peaks.min(data);
        int[] arrmax = Peaks.arrmax(data, max);
        int[] arrmin = Peaks.arrmin(data,min);
        

        mm = new int[][] {arrmin, arrmax};
        return mm;
    }
    
}

    