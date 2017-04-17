import os

categories = dict()

for dirname, dirnames, filenames in os.walk('.'):
    if (dirname.count(os.sep)==2):
        dirnames.clear()
        paths = dirname.split(os.sep)
        
        if paths[1] not in categories:
            categories[paths[1]]=list()
        questionName = paths[2]
        notes=None
        for notesName in ("notes.md","note.md"):
            if notesName in filenames:
                notes = os.path.join(dirname, notesName)
                break
        categories[paths[1]].append(tuple((questionName, dirname, notes)))
        
    #for subdirname in dirnames:
    #    print(os.path.join(dirname, subdirname))

    # print path to all filenames.
    #for filename in filenames:
    #    print(os.path.join(dirname, filename))

    # Advanced usage:
    # editing the 'dirnames' list will stop os.walk() from recursing into there.
    for hidden in (".git", ".script", ".maven-archetype"):
        if hidden in dirnames:
            # don't go into any .git directories.
            dirnames.remove(hidden)

with open('index.md', 'wt') as f:
    f.write("# Interview Programming Tests\n\n")
    for category in sorted(categories.keys()):
        questionlist = categories[category]
        f.write("## {0} \n\n".format(category));
        for q in sorted(questionlist):
            f.write("* {0} \n\n".format(q[0]));
            f.write("    * Path:<a href=\"{0}\">{0}</a>\n\n".format(q[1]));

            if q[2]!=None:
                f.write("    * Notes:<a href=\"{0}\">{0}</a>\n\n".format(q[2]));
