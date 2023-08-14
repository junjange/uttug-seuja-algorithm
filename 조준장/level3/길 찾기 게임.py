import sys
sys.setrecursionlimit(10 ** 6)

class Node(object):
    def __init__(self, info):
        self.num = info[2]
        self.pos = info[:2]
        self.left = None
        self.right = None

def add_node(tree, node):
    if tree.pos[0] > node[0]:
        if tree.left:
            add_node(tree.left, node)
        else:
            tree.left = Node(node)
    else:
        if tree.right:
            add_node(tree.right, node)
        else:
            tree.right = Node(node)
            
def preorder(node):
    path = [node.num]
    
    if node.left:
        path += preorder(node.left)
        
    if node.right:
        path += preorder(node.right)
    
    return path

def postorder(node):
    path = []
    
    if node.left:
        path += postorder(node.left)
        
    if node.right:
        path += postorder(node.right)
    
    path += [node.num]
    
    return path

            
    
def solution(nodeinfo):
    for i in range(len(nodeinfo)):
        nodeinfo[i].append(i+1)
        
    nodeinfo.sort(key=lambda x : (-x[1], x[0]))
    
    tree = Node(nodeinfo[0])
    for node in nodeinfo[1::]:
        add_node(tree, node)
    
    return [preorder(tree), postorder(tree)]
