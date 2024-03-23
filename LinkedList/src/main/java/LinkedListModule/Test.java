package LinkedListModule;

class test {


    public static void main(String[] args) {
        try {
            throw null;
        } catch (RuntimeException ex) {
            System.out.print("RuntimeException ");
        } catch (Exception ex) {
            System.out.print("Exception ");
        } catch (Error ex) {
            System.out.print("Error ");
        } finally {
            System.out.println("Finally ");
        }
    }

}
