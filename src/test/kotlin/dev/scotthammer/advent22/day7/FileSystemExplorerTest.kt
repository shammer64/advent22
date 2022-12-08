package dev.scotthammer.advent22.day7

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.fail

class FileSystemExplorerTest {

    @Test
    fun canFindDirectoryByName() {
        val fs = initWithExample()
        val directory = fs.find("e")

        assertNotNull(directory)
    }

    @Test
    fun canFindDirectorySize() {
        val fs = initWithExample()
        val directory = fs.find("e")

        directory?.let { assertEquals(584, it.size()) }
            ?: fail("Oh shit!")
    }

    @Test
    fun canGetListOfDirectoriesInclusive() {
        val fs = initWithExample()

        val directories: List<FSDirectory> = fs.directories()

        assertEquals(4, directories.size)
    }

    @Test
    fun canInitRootDirectory() {
        val input = arrayOf<String>("cd /")
        val fs = FileSystemExplorer(input)

        assertEquals("- / (dir)\n", fs.toString())
    }

    @Test
    fun canInitWithTwoLevelsOfDirectories() {
        val input = arrayOf<String>("$ cd /", "$ ls", "dir a")
        val fs = FileSystemExplorer(input)
        val expected =
"""
- / (dir)
  - a (dir)
""".trimStart()

        assertEquals(expected, fs.toString())
    }

    @Test
    fun canInitWithTwoLevelsOfDirectoriesAndFile() {
        val input = arrayOf<String>("$ cd /", "$ ls", "dir a", "14848514 b.txt")
        val fs = FileSystemExplorer(input)
        val expected =
            """
- / (dir)
  - a (dir)
  - b.txt (file, size=14848514)
""".trimStart()

        assertEquals(expected, fs.toString())
    }

    @Test
    fun canInitWithExample() {
        val fs = initWithExample()
        val expected =
"""
- / (dir)
  - a (dir)
    - e (dir)
      - i (file, size=584)
    - f (file, size=29116)
    - g (file, size=2557)
    - h.lst (file, size=62596)
  - b.txt (file, size=14848514)
  - c.dat (file, size=8504156)
  - d (dir)
    - j (file, size=4060174)
    - d.log (file, size=8033020)
    - d.ext (file, size=5626152)
    - k (file, size=7214296)
""".trimStart()

        assertEquals(expected, fs.toString())
    }

    private fun initWithExample(): FileSystemExplorer {
        val inputString =
            """
                    ${'$'} cd /
                    ${'$'} ls
                    dir a
                    14848514 b.txt
                    8504156 c.dat
                    dir d
                    ${'$'} cd a
                    ${'$'} ls
                    dir e
                    29116 f
                    2557 g
                    62596 h.lst
                    ${'$'} cd e
                    ${'$'} ls
                    584 i
                    ${'$'} cd ..
                    ${'$'} cd ..
                    ${'$'} cd d
                    ${'$'} ls
                    4060174 j
                    8033020 d.log
                    5626152 d.ext
                    7214296 k
                """.trimIndent()
        val input = inputString.split("\n").toTypedArray()
        val fs = FileSystemExplorer(input)
        return fs
    }
}