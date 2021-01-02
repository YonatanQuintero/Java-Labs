import java.util.LinkedList;
import java.util.List;

public class Lab8 {

    public static void main(String args[]) {

        Integer fromIds[] = {1, 7, 3, 4, 2, 6, 9, 5};
        Integer toIds[] = {3, 3, 4, 6, 6, 9, 5, null};

        //Integer fromIds[] = {7, 3};
        //Integer toIds[] = {3, 7};
        int startNodeId = 6;

        //System.out.println(5/2);
        System.out.println(String.format("Start node = %s. Last Node Id = %s", startNodeId, findNetworkEndpoint(startNodeId, fromIds, toIds)));

        /*startNodeId = 2;
        System.out.println(String.format("Start node = %s. Last Node Id = %s", startNodeId, findNetworkEndpoint(startNodeId, fromIds, toIds)));

        startNodeId = 5;
        System.out.println(String.format("Start node = %s. Last Node Id = %s", startNodeId, findNetworkEndpoint(startNodeId, fromIds, toIds)));*/


    }

    public static int findNetworkEndpoint(int startNodeId, Integer fromIds[], Integer toIds[]) {

        Integer node = startNodeId;
        List<Integer> path = new LinkedList<>();
        for (int i = 0; i < fromIds.length; i++) {
            if (node == fromIds[i]) {
                path.add(fromIds[i]);
                node = toIds[i];
            }
        }

        path.forEach(p -> {
            System.out.println(p);
        });

        return path.get(path.size() - 1);
    }
}
