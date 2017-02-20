/**
 * Created by Administrator on 2016/7/8.
 */
baseUrl='http://112.74.22.44:8080/airTickets/';
onerror=handleErr;
var txt="";

function handleErr(msg,url,l)
{
    txt="There was an error on this page.\n\n"
    txt+="Error: " + msg + "\n"
    txt+="URL: " + url + "\n"
    txt+="Line: " + l + "\n\n"
    txt+="Click OK to continue.\n\n"
    alert(txt)
    return true
}