public interface OperacjeDaty {
    void addD(int dni);
    void addM(int miesiac);
    void minD(int dni);
    void minM(int miesiac);
    void wykonajOperacje();
    int roznica(Data inna);

    String toString(String format);
    String wybierzFormat();
}

