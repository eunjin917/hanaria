import requests
import os
import json

# JSON 파일 경로
file_path = "lotteria.json"

# JSON 파일 읽기
with open(file_path, "r") as file:
    data = json.load(file)

# 추출한 데이터를 담을 리스트
extracted_data = []

# 객체들을 추출하여 리스트에 추가
for item in data:
    name = item.get("name")+".png"
    url = item.get("imgURL")
    if name and url:
        extracted_data.append([ name, url])

# 추출한 데이터 출력
print(extracted_data)

# 이미지를 다운로드할 폴더 생성
download_folder = "images"
if not os.path.exists(download_folder):
    os.makedirs(download_folder)

# 이미지 다운로드
for name, url in extracted_data:
    response = requests.get(url)
    if response.status_code == 200:
        file_path = os.path.join(download_folder, name)
        with open(file_path, "wb") as file:
            file.write(response.content)
        print(f"{name}을(를) 다운로드하였습니다.")
    else:
        print(f"{name}의 다운로드에 실패했습니다. 상태 코드: {response.status_code}")