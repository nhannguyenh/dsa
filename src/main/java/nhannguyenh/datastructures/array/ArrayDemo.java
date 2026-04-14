package nhannguyenh.datastructures.array;

public class ArrayDemo {

    public int getElementAtIndex(int index, int[] arrays){
        return arrays[index];
    }

    public String getAllElements(int[] arrays) {
        StringBuilder elementArrays = new StringBuilder();
        for (int index = 0; index < arrays.length; index++) {
            if (index == arrays.length - 1) {
                elementArrays.append(arrays[index]);
            } else {
                elementArrays.append(arrays[index]).append(", ");
            }
        }
        return elementArrays.toString();
    }

    public int[] addElement(int[] array, int value, int position) {
        int[] newArray = new int[array.length + 1];
        for (int index = array.length - 1; index >= 0; index--) {
            if (index == position) {
                newArray[index] = value;
            } else if (index < position) {
                newArray[index] = array[index];
            } else {
                newArray[index] = array[index - 1];
            }
        }
        return newArray;
    }
}
