package graphs;

/**
 * https://github.com/DioShaw/MinimunPatch/blob/master/MaxMin/src/maxmin/AFloyd.java
 * https://www.youtube.com/watch?v=xK0ShW9G-Ts&list=PLCLpAU8VN0j4RGemFfybZrWoSX57NbEq9&index=49
 */
public class MinPath {

    public String floydAlg(long[][] matrix) {
        int vertices = matrix.length;
        long adjacencyMatrix[][] = matrix;
        String paths[][] = new String[vertices][vertices];
        String auxPaths[][] = new String[vertices][vertices];
        String pathTraveled = null;
        StringBuilder builder = new StringBuilder();
        String littlePath = null;
        int i, j, k;
        float temp1, temp2, temp3, temp4, min;
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                paths[i][j] = null;
                auxPaths[i][j] = null;
            }
        }
        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temp1 = adjacencyMatrix[i][j];
                    temp2 = adjacencyMatrix[i][k];
                    temp3 = adjacencyMatrix[k][j];
                    temp4 = temp2 + temp3;
                    //Find min
                    min = Math.min(temp1, temp4);
                    if (temp1 != temp4) {
                        if (min == temp4) {
                            pathTraveled = null;
                            auxPaths[i][j] = String.valueOf(k);
                            paths[i][j] = pathR(i, k, auxPaths, pathTraveled) + (k + 1);
                        }
                    }
                    adjacencyMatrix[i][j] = (long) min;
                }
            }
        }
        //add path to builder
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                builder.append(String.format("[ %s ]", adjacencyMatrix[i][j]));
            }
            builder.append("\n");
        }


        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] != 1000000000) {
                    if (i != j) {
                        if (paths[i][j] == null) {
                            littlePath += "De (" + (i + 1) + "---->" + (j + 1) + ") Leave for... (" + (i + 1) + ", " + j + 1 + ")\n";
                        } else {
                            littlePath += "De (" + (i + 1) + "--->" + (j + 1) + ") ir por...  (" + (i + 1) + ", " + paths[i][j] + ", " + (j + 1) + ")\n";
                        }
                    }
                }
            }
        }

        return "La matriz de caminos mas cortos entre los difetentes vertices es: \n" + builder.toString() +
                "\n los diferentes caminos entre vertices son: \n" + littlePath;
    }

    public String pathR(int i, int k ,String[][] caminosaux,String caminorecorrido){
        if (caminosaux[i][k].equals("")) {
            return "";
        }else{
            //recursividad al billon

            int c = Integer.parseInt(caminosaux[i][k].toString());
            caminorecorrido +=pathR(i,c,caminosaux,caminorecorrido)+
                    (Integer.parseInt(caminosaux[i][k].toString())+1+" , ");

        }
        return caminorecorrido;
    }
}
