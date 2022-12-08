package dev.scotthammer.advent22.day7

class FileSystemExplorer(input: Array<String>) {

    private var root: FSDirectory = FSDirectory("/", null)

    init {
        var initPointer = root
        for (instruction in input) {
            if (instruction.startsWith("$ cd")) {
                val newDir = instruction.substring(5)
                when (newDir) {
                    "/" -> initPointer = root
                    ".." -> initPointer = initPointer.parent!!
                    else -> initPointer = initPointer.children[newDir] as FSDirectory
                }
            } else if (instruction.startsWith("dir")) {
                val newDirName = instruction.substring(4)
                initPointer.children[newDirName] = FSDirectory(newDirName, initPointer)
            } else if (instruction[0].isDigit()) {
                val splitIndex = instruction.indexOf(" ")
                val size = instruction.substring(0, splitIndex).toLong()
                val fileName = instruction.substring(splitIndex + 1)
                initPointer.children[fileName] = FSFile(fileName, size, initPointer)
            } else {
                println("Instruction not handled: $instruction")
            }
        }
    }

    override fun toString(): String {
        return root.toString()
    }

    fun find(name: String): FSObject? {
        return root.find(name)
    }

    fun directories(): List<FSDirectory> {
        val dirs = mutableListOf(root)
        dirs.addAll(root.subdirectories())
        return dirs
    }
}

abstract class FSObject(val name: String, val parent: FSDirectory?) {

    abstract fun dirEntry(level: Int): String
    protected fun indent(level: Int): String {
        var tabbing: String = ""
        for (i in 1..level) tabbing += "  "
        return tabbing
    }

    abstract fun size(): Long
}

class FSFile(name: String, val size: Long, parent: FSDirectory) : FSObject(name, parent) {

    override fun dirEntry(level: Int): String {
        return "${indent(level)}- $name (file, size=$size)\n"
    }

    override fun size(): Long {
        return this.size
    }
}

class FSDirectory(name: String, parent: FSDirectory?) : FSObject(name, parent) {

    val children: MutableMap<String,FSObject> = LinkedHashMap()

    override fun toString(): String {
        return dirEntry(0)
    }

    override fun dirEntry(level: Int): String {
        val sb = StringBuilder("${indent(level)}- $name (dir)\n")
        for (child in children.values)
            sb.append(child.dirEntry(level + 1))
        return sb.toString()
    }

    override fun size(): Long {
        var size: Long = 0
        for (child in children.values)
            size += child.size()
        return size
    }

    fun find(name: String): FSObject? {
        if (name == this.name)
            return this
        else {
            val child = children[name]
            if (child != null) return child
            else {
                for (child in children.values) {
                    if (child is FSDirectory) {
                        val found = child.find(name)
                        if (found != null) return found
                    }
                }
            }
        }
        return null
    }

    fun subdirectories(): List<FSDirectory> {
        val dirs = mutableListOf<FSDirectory>()
        for (child in children.values) {
            if (child is FSDirectory) {
                dirs.add(child)
                dirs.addAll(child.subdirectories())
            }
        }
        return dirs
    }

}
