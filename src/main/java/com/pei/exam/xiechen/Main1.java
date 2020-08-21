package com.pei.exam.xiechen;

import java.util.*;
import java.util.stream.Collectors;

class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);
        try {

            for (String nodeValue : value.split("\\|")) {

                String[] properties = nodeValue.split("\\`");
                if (properties.length != 3) throw new Exception("erroe");
                WorkflowNode node = map.get(properties[0]);

                node.timeoutMillis = Integer.parseInt(properties[1]);
                node.initialised = true;

                // Check next nodes
                if (properties[2].equals("END")) {
                    continue;
                }
                node.nextNodes = Arrays.stream(properties[2].split(","))
                        .map(p -> new WorkflowNode(p, 0, null))
                        .collect(Collectors.toList());
                node.nextNodes.forEach(p -> map.put(p.nodeId, p));

                map.put(node.nodeId, node);
            }
        } catch (Exception e) {
            head = null;
        }

        return head;
    }

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }
}

public class Main1 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            WorkflowNode node = WorkflowNode.load(cin.next());

            get(node, 0);
            System.out.println(max);
        }
    }

    static long max = 0;
    static boolean flag = false;

    static void get(WorkflowNode node, int sum) {
        if (flag || node == null) {
            return;
        }
        if (node.initialised = false) {
            max = -1;
            flag = true;
            return;
        }

        int tmp = node.timeoutMillis + sum;
        max = Math.max(max, tmp);
        if (node.nextNodes != null) {
            for (WorkflowNode nextNode : node.nextNodes) {
                get(nextNode, tmp);
            }
        }
    }
}
