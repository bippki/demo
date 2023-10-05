package com.example.demo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.*;
import one.util.streamex.StreamEx;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import static org.apache.commons.lang3.time.DateUtils.parseDate;

public class Main {
    public static void main(String[] args) throws java.text.ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<Donor> donors = new ArrayList<>();
        Donor donor = new Donor.DonorBuilder()
                .setId(1)
                .setPassportInfo("123456", dateFormat.parse("23/07/2007"), "МВД по Саратовской области")
                .setCardNumber("123456789")
                .setLastName("Иванов")
                .setFirstName("Иван")
                .setMiddleName("Иванович")
                .setDateOfBirth(dateFormat.parse("02/02/1991"))
                .setPlaceOfBirth("Москва")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("06/12/2011"), 300.0, "A", "+")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Диабет", dateFormat.parse("11/05/2005")),
                        new Donor.ChronicDisease("Астма", dateFormat.parse("20/08/2010"))
                ))
                .setMedicalHistory(List.of("Операция в 2010"))
                .build();
                donors.add(donor);

        Donor donor2 = new Donor.DonorBuilder()
                .setId(2)
                .setPassportInfo("789012", dateFormat.parse("15/03/2009"), "МВД по Московской области")
                .setCardNumber("987654321")
                .setLastName("Петров")
                .setFirstName("Петр")
                .setMiddleName("Петрович")
                .setDateOfBirth(dateFormat.parse("15/05/1985"))
                .setPlaceOfBirth("Санкт-Петербург")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("10/08/2013"), 250.0, "B", "-")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Гипертония", dateFormat.parse("03/09/2010")),
                        new Donor.ChronicDisease("Артрит", dateFormat.parse("25/02/2012"))
                ))
                .setMedicalHistory(List.of("Аллергия на пыльцу"))
                .build();
                donors.add(donor2);

        Donor donor3 = new Donor.DonorBuilder()
                .setId(3)
                .setPassportInfo("456789", dateFormat.parse("05/11/2015"), "МВД по Ростовской области")
                .setCardNumber("123123123")
                .setLastName("Сидоров")
                .setFirstName("Иван")
                .setMiddleName("Иванович")
                .setDateOfBirth(dateFormat.parse("10/10/1990"))
                .setPlaceOfBirth("Ростов-на-Дону")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("20/07/2020"), 400.0, "AB", "+")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Аллергия на пищу", dateFormat.parse("15/03/2017"))
                ))
                .setMedicalHistory(List.of("Был в госпитале в 2018 году"))
                .build();
        donors.add(donor3);

        Donor donor4 = new Donor.DonorBuilder()
                .setId(4)
                .setPassportInfo("987654", dateFormat.parse("10/12/2010"), "МВД по Краснодарскому краю")
                .setCardNumber("456456456")
                .setLastName("Козлов")
                .setFirstName("Алексей")
                .setMiddleName("Игоревич")
                .setDateOfBirth(dateFormat.parse("20/04/1988"))
                .setPlaceOfBirth("Краснодар")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("03/05/2018"), 350.0, "O", "+")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Остеохондроз", dateFormat.parse("07/07/2015")),
                        new Donor.ChronicDisease("Мигрень", dateFormat.parse("12/10/2019"))
                ))
                .setMedicalHistory(List.of("Была операция на спине"))
                .build();
        donors.add(donor4);

        Donor donor5 = new Donor.DonorBuilder()
                .setId(5)
                .setPassportInfo("111222", dateFormat.parse("01/01/2010"), "МВД по Красноярскому краю")
                .setCardNumber("555555555")
                .setLastName("Смирнов")
                .setFirstName("Андрей")
                .setMiddleName("Николаевич")
                .setDateOfBirth(dateFormat.parse("10/12/1980"))
                .setPlaceOfBirth("Красноярск")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("05/05/2015"), 200.0, "B", "-")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Аллергия на цветы", dateFormat.parse("10/08/2018"))
                ))
                .setMedicalHistory(List.of("Перелом ноги в детстве"))
                .build();
        donors.add(donor5);

        Donor donor6 = new Donor.DonorBuilder()
                .setId(6)
                .setPassportInfo("333444", dateFormat.parse("15/03/2011"), "МВД по Свердловской области")
                .setCardNumber("666666666")
                .setLastName("Ковалев")
                .setFirstName("Сергей")
                .setMiddleName("Александрович")
                .setDateOfBirth(dateFormat.parse("20/10/1995"))
                .setPlaceOfBirth("Екатеринбург")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("12/07/2017"), 180.0, "O", "+")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Гастрит", dateFormat.parse("05/09/2019")),
                        new Donor.ChronicDisease("Ревматоидный артрит", dateFormat.parse("20/12/2020"))
                ))
                .setMedicalHistory(List.of("Операция на желудке"))
                .build();
        donors.add(donor6);

        Donor donor7 = new Donor.DonorBuilder()
                .setId(7)
                .setPassportInfo("555666", dateFormat.parse("03/02/2012"), "МВД по Челябинской области")
                .setCardNumber("777777777")
                .setLastName("Козлова")
                .setFirstName("Мария")
                .setMiddleName("Александровна")
                .setDateOfBirth(dateFormat.parse("15/07/1987"))
                .setPlaceOfBirth("Челябинск")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("25/09/2018"), 220.0, "A", "+")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Астма", dateFormat.parse("18/05/2015"))
                ))
                .setMedicalHistory(List.of("Была операция на сердце"))
                .build();
        donors.add(donor7);

        Donor donor8 = new Donor.DonorBuilder()
                .setId(8)
                .setPassportInfo("777888", dateFormat.parse("22/04/2015"), "МВД по Калининградской области")
                .setCardNumber("888888888")
                .setLastName("Иванова")
                .setFirstName("Ольга")
                .setMiddleName("Игоревна")
                .setDateOfBirth(dateFormat.parse("05/11/1990"))
                .setPlaceOfBirth("Калининград")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("30/08/2020"), 280.0, "AB", "+")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Гипертония", dateFormat.parse("10/12/2019"))
                ))
                .setMedicalHistory(List.of("Повышенное давление"))
                .build();
        donors.add(donor8);

        Donor donor9 = new Donor.DonorBuilder()
                .setId(9)
                .setPassportInfo("999000", dateFormat.parse("20/03/2018"), "МВД по Воронежской области")
                .setCardNumber("999999999")
                .setLastName("Сергеев")
                .setFirstName("Виктор")
                .setMiddleName("Петрович")
                .setDateOfBirth(dateFormat.parse("12/08/1982"))
                .setPlaceOfBirth("Воронеж")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("08/04/2021"), 260.0, "B", "-")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Диабет", dateFormat.parse("15/11/2016"))
                ))
                .setMedicalHistory(List.of("Повреждение колена"))
                .build();
        donors.add(donor9);

        Donor donor10 = new Donor.DonorBuilder()
                .setId(10)
                .setPassportInfo("000111", dateFormat.parse("10/02/2013"), "МВД по Тюменской области")
                .setCardNumber("111111111")
                .setLastName("Морозов")
                .setFirstName("Антон")
                .setMiddleName("Алексеевич")
                .setDateOfBirth(dateFormat.parse("25/06/1993"))
                .setPlaceOfBirth("Москва")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("03/03/2019"), 190.0, "O", "+")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Артрит", dateFormat.parse("22/09/2014"))
                ))
                .setMedicalHistory(List.of("Был в аварии"))
                .build();
        donors.add(donor10);

        Donor donor11 = new Donor.DonorBuilder()
                .setId(11)
                .setPassportInfo("111222", dateFormat.parse("01/01/2010"), "МВД по Кемеровской области")
                .setCardNumber("222222222")
                .setLastName("Исаев")
                .setFirstName("Денис")
                .setMiddleName("Сергеевич")
                .setDateOfBirth(dateFormat.parse("30/07/1987"))
                .setPlaceOfBirth("Кемерово")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("10/11/2015"), 220.0, "A", "+")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Остеохондроз", dateFormat.parse("25/05/2012")),
                        new Donor.ChronicDisease("Гастрит", dateFormat.parse("15/08/2018"))
                ))
                .setMedicalHistory(List.of("Был в реанимации"))
                .build();
        donors.add(donor11);

        Donor donor12 = new Donor.DonorBuilder()
                .setId(12)
                .setPassportInfo("333444", dateFormat.parse("15/03/2011"), "МВД по Курганской области")
                .setCardNumber("333333333")
                .setLastName("Михайлов")
                .setFirstName("Александр")
                .setMiddleName("Иванович")
                .setDateOfBirth(dateFormat.parse("10/12/1995"))
                .setPlaceOfBirth("Сочи")
                .setBloodDonations(List.of(new Donor.BloodDonation(dateFormat.parse("12/07/2017"), 250.0, "B", "+")))
                .setChronicDiseases(List.of(
                        new Donor.ChronicDisease("Ревматоидный артрит", dateFormat.parse("20/05/2019"))
                ))
                .setMedicalHistory(List.of("Проходил реабилитацию"))
                .build();
        donors.add(donor12);

        JSONArray jsonArray = new JSONArray();
        for (Donor d : donors) {
            JSONObject donorObject = new JSONObject();
            donorObject.put("id", d.getId());
            donorObject.put("cardNumber", d.getCardNumber());
            donorObject.put("lastName", d.getLastName());
            donorObject.put("firstName", d.getFirstName());
            donorObject.put("middleName", d.getMiddleName());
            donorObject.put("dateOfBirth", dateFormat.format(d.getDateOfBirth()));
            donorObject.put("placeOfBirth", d.getPlaceOfBirth());

            JSONObject passportInfoObject = new JSONObject();
            passportInfoObject.put("passportNumber", d.getPassportInfo().getPassportNumber());
            passportInfoObject.put("issueDate", dateFormat.format(d.getPassportInfo().getIssueDate()));
            passportInfoObject.put("issuingAuthority", d.getPassportInfo().getIssuingAuthority());
            donorObject.put("passportInfo", passportInfoObject);

            JSONArray bloodDonationsArray = new JSONArray();
            for (Donor.BloodDonation blood : d.getBloodDonations()) {
                JSONObject bloodDonationObject = new JSONObject();
                bloodDonationObject.put("date", dateFormat.format(blood.getDate()));
                bloodDonationObject.put("volume", blood.getVolume());
                bloodDonationObject.put("bloodGroup", blood.getBloodGroup());
                bloodDonationObject.put("rhFactor", blood.getRhFactor());
                bloodDonationsArray.add(bloodDonationObject);
            }
            donorObject.put("bloodDonations", bloodDonationsArray);

            JSONArray chronicDiseasesArray = new JSONArray();
            for (Donor.ChronicDisease disease : d.getChronicDiseases()) {
                JSONObject chronicDiseaseObject = new JSONObject();
                chronicDiseaseObject.put("name", disease.getName());
                chronicDiseaseObject.put("diagnosisDate", dateFormat.format(disease.getDiagnosisDate()));
                chronicDiseasesArray.add(chronicDiseaseObject);
            }
            donorObject.put("chronicDiseases", chronicDiseasesArray);


            jsonArray.add(donorObject);
        }
/*
        try {
            FileWriter fileWriter = new FileWriter("donors2.json");
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        donors.remove(donor);
        donors.remove(donor2);
        donors.remove(donor3);
        donors.remove(donor4);
        donors.remove(donor5);
        donors.remove(donor6);
        donors.remove(donor7);
        donors.remove(donor8);
        donors.remove(donor9);
        donors.remove(donor10);
        donors.remove(donor11);
        donors.remove(donor12);


        try {
            FileReader fileReader = new FileReader("donors2.json");
            JSONParser jsonParser = new JSONParser();
            jsonArray = (JSONArray) jsonParser.parse(fileReader);
            for (Object obj : jsonArray) {
                JSONObject donorObject = (JSONObject) obj;

                int id = ((Long) donorObject.get("id")).intValue();
                String cardNumber1 = (String) donorObject.get("cardNumber");
                String lastName1 = (String) donorObject.get("lastName");
                String firstName1 = (String) donorObject.get("firstName");
                String middleName1 = (String) donorObject.get("middleName");
                Date dateOfBirth1 = dateFormat.parse((String) donorObject.get("dateOfBirth"));
                String placeOfBirth1 = (String) donorObject.get("placeOfBirth");

                // Извлекаем PassportInfo из JSON
                JSONObject passportInfoObject = (JSONObject) donorObject.get("passportInfo");
                String passportNumber = (String) passportInfoObject.get("passportNumber");
                Date issueDate = dateFormat.parse((String) passportInfoObject.get("issueDate"));
                String issuingAuthority = (String) passportInfoObject.get("issuingAuthority");

                // Извлекаем BloodDonations из JSON
                JSONArray bloodDonationsArra = (JSONArray) donorObject.get("bloodDonations");
                List<Donor.BloodDonation> bloodDonations = new ArrayList<>();
                for (Object bloodObj : bloodDonationsArra) {
                    JSONObject bloodDonationObject = (JSONObject) bloodObj;
                    Date bloodDonationDate1 = dateFormat.parse((String) bloodDonationObject.get("date"));
                    Double volume = (Double) bloodDonationObject.get("volume");
                    String bloodGroup = (String) bloodDonationObject.get("bloodGroup");
                    String rhFactor = (String) bloodDonationObject.get("rhFactor");
                    Donor.BloodDonation bloodDonation = new Donor.BloodDonation(bloodDonationDate1, volume, bloodGroup, rhFactor);
                    bloodDonations.add(bloodDonation);
                }

                // Извлекаем ChronicDiseases из JSON
                JSONArray chronicDiseasesArra = (JSONArray) donorObject.get("chronicDiseases");
                List<Donor.ChronicDisease> chronicDiseases = new ArrayList<>();
                for (Object diseaseObj : chronicDiseasesArra) {
                    JSONObject chronicDiseaseObject = (JSONObject) diseaseObj;
                    String diseaseName = (String) chronicDiseaseObject.get("name");
                    Date diagnosisDate1 = dateFormat.parse((String) chronicDiseaseObject.get("diagnosisDate"));
                    Donor.ChronicDisease chronicDisease = new Donor.ChronicDisease(diseaseName, diagnosisDate1);
                    chronicDiseases.add(chronicDisease);
                }
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                Donor d = new Donor.DonorBuilder()
                        .setId(id)
                        .setPassportInfo(passportNumber, issueDate, issuingAuthority)
                        .setCardNumber(cardNumber1)
                        .setLastName(lastName1)
                        .setFirstName(firstName1)
                        .setMiddleName(middleName1)
                        .setDateOfBirth(dateOfBirth1)
                        .setPlaceOfBirth(placeOfBirth1)
                        .setBloodDonations(bloodDonationsArra)
                        .setChronicDiseases(chronicDiseasesArra)
                        .build();
                donors.add(d);

                System.out.println("-----------------------------------------------------------------");
                System.out.println("Имя донора: " + donorObject.get("firstName") + " " + donorObject.get("lastName")+ " " + donorObject.get("middleName"));
                System.out.println("Дата рождения: " + donorObject.get("dateOfBirth"));
                System.out.println("Место рождения: " + donorObject.get("placeOfBirth"));
                System.out.println("Номер паспорта: " + ((JSONObject) donorObject.get("passportInfo")).get("passportNumber"));
                System.out.println("Дата выдачи паспорта: " + ((JSONObject) donorObject.get("passportInfo")).get("issueDate"));
                System.out.println("Орган, выдавший паспорт: " + ((JSONObject) donorObject.get("passportInfo")).get("issuingAuthority"));
                System.out.println("Номер карты: " + donorObject.get("cardNumber"));

                JSONArray bloodDonationsArray = (JSONArray) donorObject.get("bloodDonations");
                System.out.println("Список сдач крови:");
                for (Object bloodObj : bloodDonationsArray) {
                    JSONObject bloodDonationObject = (JSONObject) bloodObj;
                    System.out.println("Дата: " + bloodDonationObject.get("date") + ", Объем: " + bloodDonationObject.get("volume") +
                            ", Группа крови: " + bloodDonationObject.get("bloodGroup") + ", Резус-фактор: " + bloodDonationObject.get("rhFactor"));
                }

                JSONArray chronicDiseasesArray1 = (JSONArray) donorObject.get("chronicDiseases");
                System.out.println("Список хронических заболеваний:");
                for (Object diseaseObj : chronicDiseasesArray1) {
                    JSONObject chronicDiseaseObject = (JSONObject) diseaseObj;
                    System.out.println("Название: " + chronicDiseaseObject.get("name") + ", Дата диагноза: " + chronicDiseaseObject.get("diagnosisDate"));

            }}


            List<Donor.ChronicDisease> allChronicDiseases = donors.stream()
                    .flatMap(a -> a.getChronicDiseases().stream())
                    .distinct()
                    .collect(Collectors.toList());

            // Выводим список хронических заболеваний
            System.out.println("Список хронических заболеваний без повторений:");
            for (Donor.ChronicDisease disease : allChronicDiseases) {
                System.out.println("Название: " + disease.getName());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}*/


        try {
            FileReader fileReader = new FileReader("donors2.json");
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray1 = (JSONArray) jsonParser.parse(fileReader);

            List<Donor> a = new ArrayList<>();

            for (Object obj : jsonArray1) {
                JSONObject donorObject = (JSONObject) obj;

                JSONObject passportInfoObject = (JSONObject) donorObject.get("passportInfo");
                String passportNumber = (String) passportInfoObject.get("passportNumber");
                Date issueDate = dateFormat.parse((String) passportInfoObject.get("issueDate"));
                String issuingAuthority = (String) passportInfoObject.get("issuingAuthority");
                Donor.PassportInfo passportInfo = new Donor.PassportInfo(passportNumber, issueDate, issuingAuthority);
                Donor.DonorBuilder donorBuilder = new Donor.DonorBuilder()
                        .setId(Integer.parseInt(donorObject.get("id").toString()))
                        .setCardNumber(donorObject.get("cardNumber").toString())
                        .setLastName(donorObject.get("lastName").toString())
                        .setFirstName(donorObject.get("firstName").toString())
                        .setMiddleName(donorObject.get("middleName").toString())
                        .setDateOfBirth(dateFormat.parse(donorObject.get("dateOfBirth").toString()))
                        .setPlaceOfBirth(donorObject.get("placeOfBirth").toString());
                        donorBuilder.setPassportInfo(passportNumber,issueDate,issuingAuthority);


                JSONArray bloodDonationsArray = (JSONArray) donorObject.get("bloodDonations");
                List<Donor.BloodDonation> bloodDonations = new ArrayList<>();
                for (Object bloodObj : bloodDonationsArray) {
                    JSONObject bloodDonationObject = (JSONObject) bloodObj;
                    Donor.BloodDonation bloodDonation = new Donor.BloodDonation(
                            dateFormat.parse(bloodDonationObject.get("date").toString()),
                            Double.parseDouble(bloodDonationObject.get("volume").toString()),
                            bloodDonationObject.get("bloodGroup").toString(),
                            bloodDonationObject.get("rhFactor").toString()
                    );
                    bloodDonations.add(bloodDonation);
                }

                donorBuilder.setBloodDonations(bloodDonations);

                JSONArray chronicDiseasesArray = (JSONArray) donorObject.get("chronicDiseases");
                List<Donor.ChronicDisease> chronicDiseases = new ArrayList<>();
                for (Object diseaseObj : chronicDiseasesArray) {
                    JSONObject chronicDiseaseObject = (JSONObject) diseaseObj;
                    Donor.ChronicDisease chronicDisease = new Donor.ChronicDisease(
                            chronicDiseaseObject.get("name").toString(),
                            dateFormat.parse(chronicDiseaseObject.get("diagnosisDate").toString())
                    );
                    chronicDiseases.add(chronicDisease);
                }

                donorBuilder.setChronicDiseases(chronicDiseases);

                Donor donorr = donorBuilder.build();
                a.add(donorr);
            }

            for (Donor donorr : a) {
                System.out.println("ID: " + donorr.getId());
                System.out.println("Имя: " + donorr.getFirstName() + " " + donorr.getMiddleName() + " " + donorr.getLastName());
                System.out.println("Дата рождения: " + dateFormat.format(donorr.getDateOfBirth()));
                System.out.println("Место рождения: " + donorr.getPlaceOfBirth());
                System.out.println("Номер карты: " + donorr.getCardNumber());


                System.out.println("Паспортные данные:");
                Donor.PassportInfo passportInfo = donorr.getPassportInfo();
                System.out.println("Номер паспорта: " + passportInfo.getPassportNumber());
                System.out.println("Дата выдачи: " + dateFormat.format(passportInfo.getIssueDate()));
                System.out.println("Орган, выдавший паспорт: " + passportInfo.getIssuingAuthority());
                System.out.println("Сдачи крови:");
                for (Donor.BloodDonation bloodDonation : donorr.getBloodDonations()) {
                    System.out.println("Дата: " + dateFormat.format(bloodDonation.getDate()));
                    System.out.println("Объем: " + bloodDonation.getVolume());
                    System.out.println("Группа крови: " + bloodDonation.getBloodGroup());
                    System.out.println("Резус-фактор: " + bloodDonation.getRhFactor());
                }

                System.out.println("Хронические заболевания:");
                for (Donor.ChronicDisease chronicDisease : donorr.getChronicDiseases()) {
                    System.out.println("Название: " + chronicDisease.getName());
                    System.out.println("Дата диагноза: " + dateFormat.format(chronicDisease.getDiagnosisDate()));
                }

                System.out.println("============================================");
            }

            List<Donor.ChronicDisease> allChronicDiseases = a.stream()
                    .flatMap(b -> b.getChronicDiseases().stream())
                    .collect(Collectors.toMap(
                            Donor.ChronicDisease::getName,
                            disease -> disease,
                            (existing, replacement) -> existing
                    ))
                    .values()
                    .stream()
                    .collect(Collectors.toList());

            // Выводим список хронических заболеваний
            System.out.println("Список хронических заболеваний без повторений:");
            for (Donor.ChronicDisease disease : allChronicDiseases) {
                System.out.println("Название: " + disease.getName());
            }
            System.out.println("=================================================");

            Map<String, Long> diseaseCountMap = a.stream()
                    .flatMap(b -> b.getChronicDiseases().stream())
                    .collect(Collectors.groupingBy(
                            Donor.ChronicDisease::getName,
                            Collectors.counting()
                    ));

            List<Map.Entry<String, Long>> sortedDiseases = diseaseCountMap.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .collect(Collectors.toList());

            for (Map.Entry<String, Long> entry : sortedDiseases) {
                System.out.println("Болезнь: " + entry.getKey() + ", Суммарное количество доноров: " + entry.getValue());
            }

            System.out.println("=================================================");

            List<Donor> donorsFromMoscow = donors.stream()
                    .filter(b -> "Москва".equals(b.getPlaceOfBirth()))
                    .collect(Collectors.toList());

            donorsFromMoscow.forEach(b -> System.out.println("Имя: " + b.getFirstName() + ", Город: " + b.getPlaceOfBirth()));

            System.out.println("=================================================");

            List<Donor> donorsWithBloodGroupB = donors.stream()
                    .filter(b -> "B".equals(b.getBloodDonations().get(0).getBloodGroup()))
                    .collect(Collectors.toList());

            donorsWithBloodGroupB.forEach(b -> System.out.println("Имя: " + b.getFirstName() + ", Группа крови: B"));


        } catch (IOException | ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
    }
}



