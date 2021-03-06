#include <stdio.h> 
   #include <cmath> 
 
int factorial(int i) {
    int valor = i;
    int indice = i;
    while (indice-1 > 0) {
        valor *= indice-1;
        indice--;
    }
    return valor;
}

int main()
{
  while(true){
    printf("\n?Que Deseas calcular? \n1.Formula General\n2.Seno\n3.Salir \n");
    int bandera = 0;
    scanf("%d",&bandera);
    if(bandera == 1 ){
        
        //Formula General
        
        int a = 0; 
        int b = 0;
        int c = 0;
        
        printf("Introducir el valor de A:");
        scanf("%d",&a); 
        printf("Introducir el valor de B:");
        scanf("%d",&b);
        printf("Introducir el valor de C:");
        scanf("%d",&c);
        
        double resultadoSumando =  (-b + sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
        double resultadoRestando = (-b - sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
        printf("x1: %f" ,resultadoSumando); //el resultado debe de ser  -0.33
        printf(" x2: %f" ,resultadoRestando); // el resultao debe de ser -3
        
    }

    if(bandera == 2){
        
        //Seno con series 
        double seno = 0;
        bool intercalar = true;
        double x = 0;
        printf("Escribe el angulo:");
        scanf("%lf",&x); //valor a calcular el seno
        x *= 3.141592 / 180;
        for (int i = 1; i < 15;  i++)
        {
    
            if (i % 2 != 0) {
                if (intercalar) {
                    seno += pow(x, i) / factorial(i);
                    printf("%lf \n",seno);
                    intercalar = false;
                }
                else {
                    seno -= pow(x, i) / factorial(i);
                    intercalar = true;
                }
        }

    }
    printf("valor de seno: %f" ,seno); // el resultado debe de ser  1 aproximadamente
   }
   if(bandera == 3){
   break;
   }
  }
  return 0;
}