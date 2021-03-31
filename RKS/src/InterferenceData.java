public class InterferenceData {
    public int antennaID;
    public String units;
    public int value;

    InterferenceData(String data) {
        String antennaIDTag = "Антенна";
        String unitsTag = "Единицы";
        String valueTag = "Значение";

        this.antennaID = DataHandler.getTagIntValue(data, antennaIDTag);
        this.units = DataHandler.getTagStringValue(data, unitsTag);
        this.value = DataHandler.getTagIntValue(data, valueTag);
    }

    public String toString() {
        return "AntennaID=" + this.antennaID + " Units=" + this.units + " Value=" + this.value;
    }
}
