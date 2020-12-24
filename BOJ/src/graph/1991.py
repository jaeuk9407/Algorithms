import sys
sys.setrecursionlimit(1000000)

n = int(sys.stdin.readline())
tree = dict()
root = 'A'


class node:
    def __init__(self):
        self.data = None
        self.left = None
        self.right = None


def preorder(node):
    sys.stdout.write(node.data)
    if node.left is not None:
        preorder(tree[node.left])
    if node.right is not None:
        preorder(tree[node.right])


def inorder(node):
    if node.left is not None:
        inorder(tree[node.left])
    sys.stdout.write(node.data)
    if node.right is not None:
        inorder(tree[node.right])


def postorder(node):
    if node.left is not None:
        postorder(tree[node.left])
    if node.right is not None:
        postorder(tree[node.right])
    sys.stdout.write(node.data)


for i in range(n):
    input_node, input_left, input_right = sys.stdin.readline().split()
    if input_node == root:
        tree[root] = node()
        tree[root].data = input_node
        if input_left != '.':
            tree[root].left = input_left
            tree[input_left] = node()
            tree[input_left].data = input_left
        if input_right != '.':
            tree[root].right = input_right
            tree[input_right] = node()
            tree[input_right].data = input_right

    else:
        if input_left != '.':
            tree[input_node].left = input_left
            tree[input_left] = node()
            tree[input_left].data = input_left
        if input_right != '.':
            tree[input_node].right = input_right
            tree[input_right] = node()
            tree[input_right].data = input_right

preorder(tree[root])
sys.stdout.write('\n')
inorder(tree[root])
sys.stdout.write('\n')
postorder(tree[root])
