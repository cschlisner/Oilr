import tools.*;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
class q067 {
	public static void main(String[] args){
        Timer timer = new Timer();
		int[][] triangle = new int[100][];
		readTriangle(triangle, "67/triangle.txt");

		timer.start();
		int[] trail = new int[triangle.length];
		int depth = 6, X=0, total = 0;
		for (int Y=0; Y < triangle.length; ++Y){
			trail[Y] = X;
			total += triangle[Y][X];
			if (Y == triangle.length-2){
				X+= (triangle[Y+1][X] > triangle[Y+1][X+1])?0:1;
			}
			else if (Y+depth<triangle.length-1){
				int p1 = explore(triangle, Y+1, X, findPath(triangle, Y+1, X, depth), null);
				int p2 = explore(triangle, Y+1, X+1, findPath(triangle, Y+1, X+1, depth), null);
				X += (p1>p2)?0:1;
			}

		}
		timer.stop();
		timer.printTime();
		//Print.array(trail);
		Print.sln("total = "+total);
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

	private static void readTriangle(int[][] tri, String file){
		Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(file)));
            for (int i = 0; i < tri.length; ++i){
            	tri[i] = new int[i+1];
            	for (int j = 0; j < i+1; ++j){
            		if (s.hasNextInt())
            			tri[i][j] = s.nextInt();
            	}
            }
        } catch (FileNotFoundException e){}
        finally {
            if (s != null) {
                s.close();
            }
        }
	}
}