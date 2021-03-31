class CMP {
    public String name;
    public String location;
    public InterferenceData[] interferenceData;

    CMP(String jsonData) {
        String nameTag = "КИП";
        String locationTag = "Локация";
        String interferenceDataTag = "Помеховые данные";

        this.name = DataHandler.getTagStringValue(jsonData, nameTag);
        this.location = DataHandler.getTagStringValue(jsonData, locationTag);
        String[] interferenceDataArray = DataHandler.getTagArray(jsonData, interferenceDataTag);
        this.interferenceData = new InterferenceData[interferenceDataArray.length];

        for (int i = 0; i < interferenceDataArray.length; i++) {
            interferenceData[i] = new InterferenceData(interferenceDataArray[i]);
        }
    }
}