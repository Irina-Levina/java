public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] patientTempRnd = new float[patientsCount];
        for (int i = 0; i < patientTempRnd.length; i ++)
        {
            float value = (float) (Math.round((32 + 7*Math.random())*10.0)/10.0);
            patientTempRnd[i] = value;
        }

        return patientTempRnd;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        int healthyPatientCount = 1;
        float summaTmp = 0;
        float averageTmp;
        StringBuilder allTmp = new StringBuilder();

        for (float temp: temperatureData)
        {
            allTmp.append(temp + " ");
            summaTmp+=temp;
            if (temp <= 36.9 & temp >= 36.2) healthyPatientCount++;
        }
        averageTmp = (float) (Math.round(summaTmp/(temperatureData.length)*100.0)/100.0);

        String report =
                "Температуры пациентов: " + allTmp.toString().trim() +
                        "\nСредняя температура: " + averageTmp +
                        "\nКоличество здоровых: " + healthyPatientCount;

        return report;
    }
}
