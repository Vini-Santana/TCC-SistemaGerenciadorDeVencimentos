@echo off
:: Inicia o backend Spring Boot
cd /d "C:\Users\vinis\OneDrive\Documentos\TCC Workspace\TCC-SistemaGerenciadorDeVencimentos\backend"
start cmd /k "mvn spring-boot:run"

:: Inicia o frontend (ajuste o caminho se for diferente)
cd /d "C:\Users\vinis\OneDrive\Documentos\TCC Workspace\TCC-SistemaGerenciadorDeVencimentos\frontend"
start cmd /k "npm start"