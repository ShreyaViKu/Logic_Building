function countSmall(str)
{
    let i = 0;

    let iCount = 0;
    
    for(i = 0; i < str.length; i++)
    {
        if(str[i] >= 'a' && str[i] <= 'z')
        {
            iCount++;
        }
    }

    return iCount;
}
function main()
{

    let name = "Marvellous";

    let iRet = countSmall(name);

    console.log(iRet);
    
}

main();