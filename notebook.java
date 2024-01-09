public class notebook 
{
    String prodName;
    int memoryRam;
    int memoryFlash;
    String operationSystem;
    String colors;

    @Override
    public String toString() {
        
        return "производитель: " + prodName + ", ОЗУ: " + memoryRam + " Гб" + ", память: " + memoryFlash + " Гб" + ", система: " + operationSystem + ", цвет: " + colors;
    }
}