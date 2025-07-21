#!/bin/bash

# Pension
curl -X POST "http://localhost:8090/api/pensions" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"birthday\": \"2022-03-27\", \"dutyHoursDto\": [ { \"beginning\": \"2022-03-27\", \"ending\": \"2022-03-27\", \"officialId\": 0, \"restriction\": \"string\" } ], \"firstRetirementDay\": \"2022-03-27\", \"idAbbreviation\": 0, \"justificationOfficialRelationship\": \"2022-03-27\", \"officialCategory\": \"string\", \"retirementReason\": \"string\"}"
curl -X POST "http://localhost:8090/api/pensions" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"birthday\": \"2022-03-27\", \"dutyHoursDto\": [ { \"beginning\": \"2022-03-27\", \"ending\": \"2022-03-27\", \"officialId\": 0, \"restriction\": \"string\" } ], \"firstRetirementDay\": \"2022-03-27\", \"idAbbreviation\": 0, \"justificationOfficialRelationship\": \"2022-03-27\", \"officialCategory\": \"string\", \"retirementReason\": \"string\"}"
curl -X POST "http://localhost:8090/api/pensions" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"birthday\": \"2022-03-27\", \"dutyHoursDto\": [ { \"beginning\": \"2022-03-27\", \"ending\": \"2022-03-27\", \"officialId\": 0, \"restriction\": \"string\" } ], \"firstRetirementDay\": \"2022-03-27\", \"idAbbreviation\": 0, \"justificationOfficialRelationship\": \"2022-03-27\", \"officialCategory\": \"string\", \"retirementReason\": \"string\"}"
curl -X POST "http://localhost:8090/api/pensions" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"birthday\": \"2022-03-27\", \"dutyHoursDto\": [ { \"beginning\": \"2022-03-27\", \"ending\": \"2022-03-27\", \"officialId\": 0, \"restriction\": \"string\" } ], \"firstRetirementDay\": \"2022-03-27\", \"idAbbreviation\": 0, \"justificationOfficialRelationship\": \"2022-03-27\", \"officialCategory\": \"string\", \"retirementReason\": \"string\"}"
curl -X POST "http://localhost:8090/api/pensions" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"birthday\": \"2022-03-27\", \"dutyHoursDto\": [ { \"beginning\": \"2022-03-27\", \"ending\": \"2022-03-27\", \"officialId\": 0, \"restriction\": \"string\" } ], \"firstRetirementDay\": \"2022-03-27\", \"idAbbreviation\": 0, \"justificationOfficialRelationship\": \"2022-03-27\", \"officialCategory\": \"string\", \"retirementReason\": \"string\"}"

# Duty-Hour
curl -X POST "http://localhost:8090/api/dutyhours" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"beginning\": \"2022-03-27\", \"ending\": \"2022-03-27\", \"partTime\": \"1/2\", \"officialId\": 11, \"restriction\": \"1J\"}"
curl -X POST "http://localhost:8090/api/dutyhours" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"beginning\": \"2022-03-27\", \"ending\": \"2022-03-27\", \"partTime\": \"2/3\", \"officialId\": 22, \"restriction\": \"22T\"}"
curl -X POST "http://localhost:8090/api/dutyhours" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"beginning\": \"2022-03-27\", \"ending\": \"2022-03-27\", \"partTime\": \"3/3\", \"officialId\": 33, \"restriction\": \"3J 3T\"}"
curl -X POST "http://localhost:8090/api/dutyhours" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"beginning\": \"2022-03-29\", \"ending\": \"2022-03-29\", \"partTime\": \"1/2\", \"officialId\": 44, \"restriction\": \"6J 36T\"}"

# Official-Category
curl -X POST "http://localhost:8090/api/officialcategory" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Allgemeine Verwaltung\"}"
curl -X POST "http://localhost:8090/api/officialcategory" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Lehrer\"}"
curl -X POST "http://localhost:8090/api/officialcategory" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Professor FH\"}"
curl -X POST "http://localhost:8090/api/officialcategory" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Professor\"}"
curl -X POST "http://localhost:8090/api/officialcategory" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Feuerwehrbeamter\"}"
curl -X POST "http://localhost:8090/api/officialcategory" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Vollzugsbeamter\"}"
curl -X POST "http://localhost:8090/api/officialcategory" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Polizeibeamter\"}"


### retirement reason ###
curl -X POST "http://localhost:8090/api/retirementreason" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Regelaltersgrenze\"}"
curl -X POST "http://localhost:8090/api/retirementreason" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Dienstunfähigkeit\"}"
curl -X POST "http://localhost:8090/api/retirementreason" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Schwerbehinderung\"}"
curl -X POST "http://localhost:8090/api/retirementreason" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"Antragsaltersgrenze\"}"


# Offical-Time-Key
curl -X POST "http://localhost:8090/api/officialtimekey" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"keyOTK\": 301, \"name\": \"Dienstzeit Betrittsgebiet\"}"
curl -X POST "http://localhost:8090/api/officialtimekey" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"keyOTK\": 1301, \"name\": \"Beamtendienstzeit\"}"
curl -X POST "http://localhost:8090/api/officialtimekey" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"keyOTK\": 1303, \"name\": \"Beurlbg. ohne Dienstbezüge/Elternzeit\"}"
curl -X POST "http://localhost:8090/api/officialtimekey" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"keyOTK\": 1305, \"name\": \"Beurlbg. m. öffentl. Belang\"}"
curl -X POST "http://localhost:8090/api/officialtimekey" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"keyOTK\": 1307, \"name\": \"Vorbereitungsdienst\"}"
curl -X POST "http://localhost:8090/api/officialtimekey" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"keyOTK\": 1311, \"name\": \"Altersteilzeit § 75a, 75b LBG\"}"
curl -X POST "http://localhost:8090/api/officialtimekey" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"keyOTK\": 1313, \"name\": \"Altersteilzeit  §80b LBG\"}"
curl -X POST "http://localhost:8090/api/officialtimekey" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"keyOTK\": 1314, \"name\": \"begr. Dienstfähigkeit\"}"
curl -X POST "http://localhost:8090/api/officialtimekey" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"keyOTK\": 1336, \"name\": \"Rechtsreferendare\"}"

# Family-Allowance
curl -X POST "http://localhost:8090/api/familyallowance" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"ohne Familienzuschlag\"}"
curl -X POST "http://localhost:8090/api/familyallowance" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"halber Familienzuschlag\"}"
curl -X POST "http://localhost:8090/api/familyallowance" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"name\": \"voller Familienzuschlag\"}"

# relation between pension and duty-hour
curl -X POST "http://localhost:8090/api/pensions/2/dutyhours/3/add" -H "accept: */*"
curl -X POST "http://localhost:8090/api/pensions/2/dutyhours/2/add" -H "accept: */*"
curl -X POST "http://localhost:8090/api/pensions/5/dutyhours/1/add" -H "accept: */*"

# relation between pension and retirement-reason
curl -X POST "http://localhost:8090/api/pensions/1/retirementreason/4/add" -H "accept: */*"
curl -X POST "http://localhost:8090/api/pensions/2/retirementreason/1/add" -H "accept: */*"

# relation between pension and family-allowance
curl -X POST "http://localhost:8090/api/pensions/1/familyallowance/2/add" -H "accept: */*"
curl -X POST "http://localhost:8090/api/pensions/2/familyallowance/3/add" -H "accept: */*"

# relation between duty-hour and official-time-key
curl -X POST "http://localhost:8090/api/dutyhours/2/officialtimekey/2/add" -H "accept: */*"
curl -X POST "http://localhost:8090/api/dutyhours/3/officialtimekey/9/add" -H "accept: */*"
curl -X POST "http://localhost:8090/api/dutyhours/1/officialtimekey/7/add" -H "accept: */*"

## relation betweem pension and official-category
curl -X POST "http://localhost:8090/api/pensions/1/officialcategory/3/add" -H "accept: */*"
