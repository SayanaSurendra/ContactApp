package se.lexicon;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameRepositoryTest {

    @BeforeEach
    void setUp() {
        NameRepository.clear();
        NameRepository.setNames(new String[]{"Philip Thomas", "Ulf Svensson"});
    }

    @Test
    void testGetSize() {
        System.out.println(NameRepository.getSize());
        assertEquals(2, NameRepository.getSize());

    }

    @Test
    void testSetNames() {

        NameRepository.setNames(new String[]{"Sayana Surendran","Erik Svensson"});
        String[] names = NameRepository.findAll();
        assertArrayEquals(new String[]{"Sayana Surendran","Erik Svensson"}, names);

    }


    @Test
    void testFindAll() {
        assertArrayEquals(new String[]{"Philip Thomas", "Ulf Svensson"},NameRepository.findAll());
    }


    @Test
    public void testClear(){
        NameRepository.clear();
        assertEquals(0,NameRepository.getSize());
    }

    @Test
    void testFind() {
        assertEquals("Philip Thomas", NameRepository.find("Philip Thomas"));
        assertNull(NameRepository.find("Not Found"));
    }

    @Test
    void testAdd() {
        assertTrue(NameRepository.add("Sayana Surendran"));
        assertFalse(NameRepository.add("Sayana Surendran"));
    }

    @Test
    void testFindByFirstName() {
        assertArrayEquals(new String[]{"Philip Thomas"}, NameRepository.findByFirstName("Philip"));
        assertArrayEquals(new String[]{}, NameRepository.findByFirstName("Sayana"));
    }

    @Test
    void testFindByLastName() {

        assertArrayEquals(new String[]{"Philip Thomas"}, NameRepository.findByLastName("Thomas"));
        assertArrayEquals(new String[]{}, NameRepository.findByLastName("Surendran"));
    }

    @Test
    void testUpdate() {
        assertTrue(NameRepository.update("Philip Thomas","Erik Svensson"));
        assertFalse(NameRepository.update("Fredrik Johnsson","Erik Newton"));
    }

    @Test
    void testRemove() {
       assertTrue(NameRepository.remove("Philip Thomas"));
       assertFalse(NameRepository.remove("Sayana Surendran"));
    }
}