[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
$content = Get-Content -Path 'C:\UPC2026\RestauranteElBuenSabor\docs\temp_guia\word\document.xml' -Raw
$content = $content -replace '<[^>]+>', ' '
$content = $content -replace '\s+', ' '
$content = $content.Trim()
$content | Out-File -FilePath 'C:\UPC2026\RestauranteElBuenSabor\docs\guia_text.txt' -Encoding UTF8
Write-Host "Extracted Guia text"
