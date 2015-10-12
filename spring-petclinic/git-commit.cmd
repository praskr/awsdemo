git status
git add --all
git status
set /p commitComment=Enter the Commit Comment:%=%
git commit -m "%commitComment%"
git status
git remote set-url origin https://praskr:test1234@github.com/praskr/awsdemo.git
git push origin master