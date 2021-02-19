package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BinaryTree {

    static List<User> userTable = new ArrayList<>();
    static List<Network> networkTable = new ArrayList<>();

    public static void main(String args[]) {

        fillUserTable();

        for (User user : userTable) {
            solution(user, user.sponsor);
        }

        for (Network network : networkTable) {
            System.out.println(String.format("Id = [%s] User = [%s] Parent = [%s]", network.id, network.user.name, network.parent != null ? network.parent.name : null));
        }

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

    private static void insert(User child, User parent) {
        networkTable.add(new Network(child, parent, networkTable.size()));
    }

    private static List<User> findChildrenByParent(User parent) {
        List<User> children = new ArrayList<>();
        for (Network network : networkTable) {
            if (network.parent != null && network.parent.id == parent.id) {
                children.add(network.user);
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
