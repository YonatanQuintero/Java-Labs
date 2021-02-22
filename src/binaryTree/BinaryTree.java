package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BinaryTree {

    static List<User> userTable = new ArrayList<>();
    static List<Network> networkTable = new ArrayList<>();

    public static void main(String args[]) {

        //Better solution
        /*int n = 60;
        for (int i = 0; i < n; i++) {//n*50
            fillUserTable();
        }*/
        fillUserTable();
        for (User user : userTable) {
            canBeExtend2(user, user.sponsor);
        }
        for (Network network : networkTable) {
            System.out.println(String.format("Id = [%s] User = [%s] Parent = [%s]", network.id, network.user.name, network.parent != null ? network.parent.name : null));
        }

       /* List<String> path = new ArrayList<>();
        findPath(findUserByName("24"), path);

        for (String p : path) {
            System.out.println(p);
        }
        User user = findUserByName("8");
        User parent = findNetworkParent(findNetworkUser(user));
        doSomethingInPath(parent, user);*/


        // Solution
        /*fillUserTable();

        for (User user : userTable) {
            solution(user, user.sponsor);
        }

        for (Network network : networkTable) {
            System.out.println(String.format("Id = [%s] User = [%s] Parent = [%s]", network.id, network.user.name, network.parent != null ? network.parent.name : null));
        }*/

        /** Print all children network
         fillUserTable();
         fillNetwork();
         List<User> parents = new ArrayList<>();
         parents.add(findUserByName("1"));
         List<User> children = new ArrayList<>();
         fillChildren(parents, children, 3, 0);

         for (User user : children) {
         System.out.println(String.format("Id = [%s] User = [%s] Parent = [%s]", user.id, user.name, user.sponsor));
         }*/



        /*for (User user : userTable) {
            solution(user, user.sponsor);
        }*/

        /*for (Network network : networkTable) {
            System.out.println(String.format("Id = [%s] User = [%s] Parent = [%s]", network.id, network.user.name, network.parent != null ? network.parent.name : null));
        }*/

        /*for (User user : userTable) {
            System.out.println(String.format("Id = [%s] User = [%s] Parent = [%s]", user.id, user.name, user.sponsor));
        }*/
    }

    private static void doSomethingInPath(User parent, User user) {
        if (parent == null) return;
        System.out.println(String.format("Pay binary points to parent.name [%s] from user.name [%s]", parent.name, user.name));
        parent = findNetworkParent(findNetworkUser(parent));
        doSomethingInPath(parent, user);

    }

    private static void findPath(User user, List<String> path) {

        if (user == null) return;

        path.add(user.name);
        user = findNetworkParent(findNetworkUser(user));
        findPath(user, path);
    }

    private static void solution(User child, User parent) {
        if (parent == null) {
            insert(child, parent);
            return;
        }
        List<User> parents = new ArrayList<>();
        parents.add(parent);
        List<User> children = new ArrayList<>();
        fillChildren(parents, children, 3, 0);

        if (children.size() < 2) {
            insert(child, parent);
            return;
        }
        for (User p : children) {
            List<User> k = findChildrenByParent(p);
            if (k.size() < 2) {
                insert(child, p);
                return;
            }
        }
    }


   /* private static boolean canBeExtend(User child, User parent) {
        if (parent == null) {
            insert(child, parent);
            return false;
        }
        List<User> parents = new ArrayList<>();
        parents.add(parent);
        List<User> children = new ArrayList<>();
        betterSolution(parents, children);

        if (children.size() < 2) {
            insert(child, parent);
            return false;
        }
        for (User p : children) {
            List<User> k = findChildrenByParent(p);
            if (k.size() < 2) {
                insert(child, p);
                return false;
            }
        }
        return true;
    }*/

    private static void canBeExtend2(User child, User parent) {
        List<User> parents = new ArrayList<>();
        parents.add(parent);
        betterSolution2(parents, child);

    }

    private static void betterSolution2(List<User> parents, User child) {

        Network n = findNetworkUser(child);
        if (n != null) return;

        List<User> children = new ArrayList<>();

        for (User p : parents) {
            List<User> c = findChildrenByParent(p);
            if (c.size() < 2) {
                insert(child, p);
                return;
            }
            children.addAll(c);
        }
        betterSolution2(children, child);
    }

    private static void betterSolution(List<User> parents, User child) {

        List<User> children = new ArrayList<>();
        for (User p : parents) {
            children.addAll(findChildrenByParent(p));
            if (children.size() < 2) {
                insert(child, p);
                return;
            }
            for (User c : children) {
                List<User> k = findChildrenByParent(c);
                if (k.size() < 2) {
                    insert(child, c);
                    return;
                }
            }
        }
        //if (children.isEmpty()) { System.out.println("Empty return"); return;}
        //parents = children;
        betterSolution(children, child);
    }

    /* private static boolean solution(User child, User parent) {

         if (parent == null) {
             insert(child, parent);
             return true;
         }
         List<User> children = findChildrenByParent(parent);
         if (children.size() < 2) {//Is available
             insert(child, parent);
             return true;
         } else if (parent.sponsor != null) {
             return false;
         } else {
             for (User parentK : children) {
                 if (solution(child, parentK)) {
                     return true;
                 }
             }
         }
         return true;
     }*/

    private static void fillUserTable() {


        userTable.add(new User("1", null, userTable.size()));
        userTable.add(new User("2", findUserByName("1"), userTable.size()));
        userTable.add(new User("3", findUserByName("1"), userTable.size()));
        userTable.add(new User("4", findUserByName("1"), userTable.size()));
        userTable.add(new User("5", findUserByName("1"), userTable.size()));
        userTable.add(new User("6", findUserByName("3"), userTable.size()));
        userTable.add(new User("7", findUserByName("2"), userTable.size()));
        userTable.add(new User("8", findUserByName("4"), userTable.size()));
        userTable.add(new User("9", findUserByName("2"), userTable.size()));
        userTable.add(new User("10", findUserByName("4"), userTable.size()));
        userTable.add(new User("11", findUserByName("4"), userTable.size()));
        userTable.add(new User("12", findUserByName("4"), userTable.size()));
        userTable.add(new User("13", findUserByName("2"), userTable.size()));
        userTable.add(new User("14", findUserByName("1"), userTable.size()));
        userTable.add(new User("15", findUserByName("2"), userTable.size()));
        userTable.add(new User("16", findUserByName("2"), userTable.size()));
        userTable.add(new User("17", findUserByName("1"), userTable.size()));
        userTable.add(new User("18", findUserByName("17"), userTable.size()));
        userTable.add(new User("19", findUserByName("18"), userTable.size()));
        userTable.add(new User("20", findUserByName("18"), userTable.size()));
        userTable.add(new User("21", findUserByName("2"), userTable.size()));
        userTable.add(new User("22", findUserByName("5"), userTable.size()));
        userTable.add(new User("23", findUserByName("2"), userTable.size()));
        userTable.add(new User("24", findUserByName("2"), userTable.size()));
        userTable.add(new User("25", findUserByName("1"), userTable.size()));

        //
        userTable.add(new User("26", findUserByName("1"), userTable.size()));
        userTable.add(new User("27", findUserByName("1"), userTable.size()));
        userTable.add(new User("28", findUserByName("1"), userTable.size()));
        userTable.add(new User("29", findUserByName("1"), userTable.size()));
        userTable.add(new User("30", findUserByName("1"), userTable.size()));
        userTable.add(new User("31", findUserByName("3"), userTable.size()));
        userTable.add(new User("32", findUserByName("2"), userTable.size()));
        userTable.add(new User("33", findUserByName("4"), userTable.size()));
        userTable.add(new User("34", findUserByName("2"), userTable.size()));
        userTable.add(new User("35", findUserByName("4"), userTable.size()));
        userTable.add(new User("36", findUserByName("4"), userTable.size()));
        userTable.add(new User("37", findUserByName("4"), userTable.size()));
        userTable.add(new User("38", findUserByName("2"), userTable.size()));
        userTable.add(new User("39", findUserByName("1"), userTable.size()));
        userTable.add(new User("40", findUserByName("2"), userTable.size()));
        userTable.add(new User("41", findUserByName("2"), userTable.size()));
        userTable.add(new User("42", findUserByName("1"), userTable.size()));
        userTable.add(new User("43", findUserByName("17"), userTable.size()));
        userTable.add(new User("44", findUserByName("18"), userTable.size()));
        userTable.add(new User("45", findUserByName("18"), userTable.size()));
        userTable.add(new User("46", findUserByName("2"), userTable.size()));
        userTable.add(new User("47", findUserByName("5"), userTable.size()));
        userTable.add(new User("48", findUserByName("2"), userTable.size()));
        userTable.add(new User("49", findUserByName("2"), userTable.size()));
        userTable.add(new User("50", findUserByName("1"), userTable.size()));

    }

    private static void fillNetwork() {
        insert(findUserByName("1"), null);
        insert(findUserByName("2"), findUserByName("1"));
        insert(findUserByName("3"), findUserByName("1"));
        insert(findUserByName("4"), findUserByName("2"));
        insert(findUserByName("5"), findUserByName("2"));
        insert(findUserByName("6"), findUserByName("3"));
        insert(findUserByName("7"), findUserByName("4"));
        insert(findUserByName("8"), findUserByName("4"));
    }

    private static void fillChildren(List<User> parents, List<User> children, int height, int level) {
        /*if (height == level) {
            return;
        }*/
        List<User> childAux = new ArrayList<>();
        for (User parent : parents) {
            childAux.addAll(findChildrenByParent(parent));
        }
        if (childAux.isEmpty()) return;
        parents = childAux;
        children.addAll(childAux);
        //level++;
        fillChildren(parents, children, height, level);
    }

    /*private static void solution(User child, User parent) {

        if (parent == null) {
            insert(child, parent);
            return;
        }

        List<User> children = findChildrenByParent(parent);
        if (children.size() == 2) {
            for (User parentK : children) {
                solution(child, parentK);
                children.remove(children.size() - 1);
            }
        } else {
            insert(child, parent);
            return;
        }
    }*/

    private static User findNetworkParent(Network userNetwork) {
        if (userNetwork == null) return null;
        for (Network network : networkTable) {
            if (userNetwork.parent != null && userNetwork.parent.id == network.user.id) {
                return network.user;
            }
        }
        return null;
    }

    private static Network findNetworkUser(User user) {
        if (user == null) return null;
        for (Network network : networkTable) {
            if (network.user.id == user.id) return network;
        }
        return null;
    }

    private static void insert(User child, User parent) {
        networkTable.add(new Network(child, parent, networkTable.size()));
    }

    private static List<User> findChildrenByParents(List<User> parents) {
        List<User> children = new ArrayList<>();
        for (User p : parents) {
            children.addAll(findChildrenByParent(p));
        }
        return children;
    }

    private static List<User> findChildrenByParent(User parent) {
        List<User> children = new ArrayList<>();
        if (parent != null) {
            for (Network network : networkTable) {
                if (network.parent != null && network.parent.id == parent.id) {
                    children.add(network.user);
                }
            }
        }
        return children;
    }

    private static User findUserByName(String name) {
        for (User user : userTable) {
            if (user.name.equals(name)) {
                return user;
            }
        }
        return null;
    }

    public static class User {

        Integer id;
        String name;
        User sponsor;

        public User(String name, User sponsor, int index) {
            this.name = name;
            this.sponsor = sponsor;
            this.id = index + 1;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("name='" + name + "'")
                    .add("sponsor=" + sponsor)
                    .toString();
        }
    }

    public static class Network {

        Integer id;
        User user;
        User parent;

        public Network(User user, User parent, int index) {
            this.user = user;
            this.parent = parent;
            this.id = index + 1;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Network.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("user=" + user)
                    .add("parent=" + parent)
                    .toString();
        }
    }
}
