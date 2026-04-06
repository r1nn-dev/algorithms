import java.io.*;
import java.util.*;

class Main {

    static class Node {
        String name;
        TreeMap<String, Node> children = new TreeMap<>();
        Node parent;

        Node(String name) {
            this.name = name;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node root = new Node("root");
        Node current = root;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            if (line.equals("cd..")) {
                if (current.parent != null) {
                    current = current.parent;
                }
            } else {
                StringTokenizer st = new StringTokenizer(line);
                String cmd = st.nextToken();

                if (cmd.equals("mkdir")) {
                    String name = st.nextToken();

                    if (!current.children.containsKey(name)) {
                        Node newNode = new Node(name);
                        newNode.parent = current;
                        current.children.put(name, newNode);
                    }

                } else if (cmd.equals("cd")) {
                    String name = st.nextToken();

                    if (current.children.containsKey(name)) {
                        current = current.children.get(name);
                    }
                }
            }
        }

        dfs(root, 0);

        System.out.print(sb);
    }

    static void dfs(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            sb.append(" ");
        }
        sb.append(node.name).append("\n");

        for (Node child : node.children.values()) {
            dfs(child, depth + 1);
        }
    }
}
