package question547

//import ("fmt")

func findCircleNum(M [][]int) int {
    n := len(M)
    friends := make([]*FriendCircle, n)
    for i:=0; i<n; i+=1 {
        friends[i] = NewFriendCircle(i)
    }
    
    for i:=0; i<n; i+=1 {
        for j:=0; j<n; j+=1 {
            if i!=j && M[i][j]==1 {
                friends[i].Join(friends[j])
            }
        }
    }
    
    result :=0
    for i:=0; i<n; i+=1 {
        if friends[i].parent==friends[i] {
            result+=1
            //fmt.Println(i)
        }
    }
    return result
}

type FriendCircle struct {
    id int
    other []int
    parent *FriendCircle
}

func NewFriendCircle(id int) *FriendCircle {
    f:= new(FriendCircle)
    f.id = id
    f.parent = f
    return f
}

func (this *FriendCircle) Join(f *FriendCircle) {
    if this==f {
        return
    }
    this.GetRoot()
    f.GetRoot()
    
    if this.parent==f.parent {
        return
    }
    if (this.parent.id<f.parent.id) {
        f.parent.parent = this.parent
        f.GetRoot()
    } else {
        this.parent.parent = f.parent
        this.GetRoot()
    }
}

func (this *FriendCircle) GetRoot() *FriendCircle {
    root := this
    for root.parent!=root {
        root = root.parent
    }
    cur := this
    for cur.parent!=cur {
        tmp:= cur.parent
        cur.parent=root
        cur = tmp
    }
    return root
}
