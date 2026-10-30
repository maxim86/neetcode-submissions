class MinStack {
    int size;
    int lastIdx;
    int[] array;
    int[] min;

    public MinStack() {
        lastIdx=-1;
        size = 10;
        array = new int[size];  
        min = new int[size];
    }
    
    public void push(int val) {
        if (lastIdx == size - 1) {
            int[] newArr = new int[size * 2];
            int[] newMin = new int[size * 2];
            System.arraycopy(array, 0, newArr, 0, size);
            System.arraycopy(min, 0, newMin, 0, size);
            size = size * 2;
            array = newArr;
            min = newMin;
        }

        if (lastIdx == -1) {
            min[0] = val; 
        } else {
            min[lastIdx + 1] = Math.min(val, min[lastIdx]);
        }
        array[lastIdx + 1] = val;
        lastIdx++;
    }
    
    public void pop() {
        lastIdx--;
    }
    
    public int top() {
        return array[lastIdx];
    }
    
    public int getMin() {
        return min[lastIdx];
    }
}
