function sumDigits(no)
{
    let sum = 0;
    let iDigit = 0;

    while(no != 0)
    {
        iDigit = no % 10;

        sum = sum + iDigit;

        no = Math.trunc(no / 10);
    }

    return sum;
}
function main()
{
    
    let iRet = sumDigits(257);

    console.log(iRet)
}

main();