import tools.*;
import java.util.Arrays;
class q018 {
	public static void main(String[] args){
		int[][] triangle = 
				{{75},
				 {95, 64},
				 {17, 47, 82},
				 {18, 35, 87, 10},
				 {20, 4, 82, 47, 65},
				 {19, 1, 23, 75, 3, 34},
				 {88, 2, 77, 73, 7, 63, 67},
			     {99, 65, 4, 28, 6, 16, 70, 92},
				 {41, 41, 26, 56, 83, 40, 80, 70, 33},
				 {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
				 {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
				 {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
				 {91, 71, 52, 38 , 17, 14, 91, 43, 58, 50, 27, 29, 48},
				 {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
				 {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}};
		int[] path = findPath(triangle, 0, 0, 14);
		int[] trail = new int[triangle.length];
		int total = explore(triangle, 0, 0, path, trail);
		Print.s("Path: ");
		Print.arrayln(trail);
		Print.triangle(triangle, trail);
		Print.sln("Total: "+total);
	}

	private static int[] findPath(int[][] tree, int row, int column, int depth){
		int[][] paths = List.binaryCount(depth);
		int[] results = new int[paths.length];
		int i=0;
		for (int[] path : paths){
			results[i++] = explore(tree, row, column, path, null);
		}
		int[] index = new int[paths.length];
		for (i=0; i<index.length; ++i) index[i] = i;
		index = Sort.size(results, index);
		return paths[index[index.length-1]];
	}

	private static int explore(int[][] tree, int row, int column, int[] path, int[] trail){
		if (trail!=null) trail[row] = column;
		return tree[row][column]+((path.length>0)?(explore(tree, row+1, column+=path[0], (Arrays.copyOfRange(path, 1, path.length)), trail)):0);
	}
}