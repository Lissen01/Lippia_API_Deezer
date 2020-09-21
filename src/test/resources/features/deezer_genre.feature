Feature: Deezer API
  COMO usario de Deezer API
  DESEO obtener la informacion del genero musical
  PARA mostrar las mismas

  @Deezer
  Scenario Outline: Obtengo la información del genero musical
    When realizo una peticion '<operation>' a '<entity>' al endpoint de genero - '<request>'
    Then obtengo el status code '<statusCode>'
    And los datos son correctos
  @200
    Examples:
      | request                 | statusCode | operation | entity |
      | request/rq_deezer_genre | 200        | GET       | GENRE  |
