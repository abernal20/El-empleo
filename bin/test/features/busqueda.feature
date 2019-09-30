# language: es
# encoding: iso-8859-1
Caracter�stica: Busqueda
  Como usuario del sistema de busqueda
  deseo poder ingresar los datos correspondientes
  para para obtener el proceso visualizaci�n de ofertas

  Esquema del escenario: Busqueda exitosa
    Dado que estoy en la pagina de elemplo
    Cuando ingreso los datos <Cargo> y <Ciudad>    
    Cuando ingrese a las ofertas seleccionar el <RangoSalario>
    Cuando seleccione el rango de salario ingreso la <FechaPublicacion>
    Cuando seleccione la fecha publicacion ingreso el <AreaDetrabajo>
    Y ya ingresados los datos quiero obtener un archivo plano con las ofertas filtradas donde me muestre el<NombreOferta> y <NombreCopa�ia>     

    Ejemplos: 
      | Cargo | Ciudad | RangoSalario | FechaPublicacion | AreaDetrabajo               |
      | Cont  | Bogot� | $1 a $1,5    | Hace 1 semana    | Administrativa y Financiera |
