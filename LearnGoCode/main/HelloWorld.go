package main

import (
	"bufio"
	"fmt"
	"os"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {
		line := scanner.Text()
		if line == "" {
			break
		}
		fmt.Printf(line)

	}
}
func printTree(root *TreeNode) [][]string {
	var ans [][]string
	if root == nil {
		return ans
	}
	var queue []*TreeNode
	queue = append(queue, root)
	pre := 1
	//next := 0
	//next = 1
	var arr []string
	for len(queue) > 0 {
		tmp := queue[0]
		queue = queue[1:]
		pre--
		if tmp == nil {
			arr = append(arr, " ")
		} else {

		}

	}
	return nil
}
