//Bibliotecas
#include <SoftwareSerial.h>

//Variaveis
int ledRed = 12; //Led Vermelho na porta 12
int ledGreen = 11; //Led verde na porta 11
SoftwareSerial In = SoftwareSerial(10, 1); //Leitor de entrada (RX) na porta 10; transmissao (TX) na porta 1 (inutil para esse caso)

String tag_lida = "";
String input = "";  

void setup()
{
Serial.begin(9600); //Comunicacao Serial com o PC (Software)
In.begin(9600); //Comunicacao Serial com o leitor RFID
pinMode(ledGreen, OUTPUT); //Define ledverde como saida
pinMode(ledRed, OUTPUT); //Define ledvermelho como saida
}
 
void loop ()
{
  if(In.available() > 0){Leitor();} //Se receber dados do leitor RFID, vai para a funcao Leitor
}

void Leitor() //Funcao para leitura da TAG lida pelo Leitor
{
  tag_lida = In.readString(); //Le a informacao passada pelo leitor (aqui ja le a tag toda)
  while(In.available() > 0) { In.read(); } //Enquanto tiver mais informacao, leia (descartar caracteres inuteis)
  tag_lida = tag_lida.substring(1,tag_lida.length() - 2); //Remove o primeiro (STX) e o ultimo (ETX) caractere da tag lida
  Software();
}

void Software() //Funcao para leitura da Informacao mandada pelo Software
{ 
  input = "";
  Serial.println(tag_lida); //Manda para o Software a TAG lida
  Serial.flush(); //Aguarda ate que a informacao seja mandada completamente
  while(Serial.available()<=0) {} //Loop para espera do retorno do Software
  while(Serial.available()>0) { //Le um char de cada vez da informacao mandada pelo Software
    char c = Serial.read(); 
    input += c;
    delay(2);  //Delay para possibilitar que a informacao seja lida
  }
  while(Serial.available()>0){Serial.read();} //Enquanto tiver mais informacao, leia (descartar caracteres inuteis)
  Led();
}

void Led()
{
  if (input.substring(0,1) == "2") //Se o primeiro caractere for `2`, acenda led vermelho
  {
  digitalWrite(ledRed, HIGH);
  delay(1500);
  digitalWrite(ledRed, LOW);
  }
  else if (input.substring(0,1) == "1") //Se o primeiro caractere for `1`, acenda led verde
  {
  digitalWrite(ledGreen, HIGH);
  delay(1500);
  digitalWrite(ledGreen, LOW);
  }
}

