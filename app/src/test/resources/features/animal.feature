#language: pt

Funcionalidade: Gerenciamento de um animal da loja

  #@deleteAllPet
  Cenario: lista somente animais disponiveis para a venda
    Dada que possua animais available
    Quando eu pesquiso por todos os animais available
    Entao eu recebo a lista de animais available
