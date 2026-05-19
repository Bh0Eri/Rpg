# Eric's RPG

Um RPG de terminal desenvolvido em **Java**, com foco em **Programação Orientada a Objetos**, criação de personagens, classes, habilidades, monstros, combate por turnos e progressão por XP.

O projeto foi criado como prática de lógica, organização de código e estruturação de sistemas simples usando Java puro.

---

## Sobre o projeto

**Eric's RPG** é um jogo em terminal onde o jogador pode criar personagens, escolher uma classe, enfrentar monstros de diferentes dificuldades, ganhar experiência e evoluir de nível.

A proposta do projeto é simular a base de um RPG clássico, com elementos como:

- Personagens jogáveis
- Classes diferentes
- Sistema de habilidades
- Monstros com dificuldades variadas
- Combate por turnos
- Ganho de XP
- Evolução de nível
- Cura de personagem

---

## Tecnologias utilizadas

- Java
- Programação Orientada a Objetos
- Herança
- Interfaces
- Enums
- Collections
- Scanner
- Random

---

## Funcionalidades

- Criar personagem
- Escolher classe do personagem
- Listar personagens criados
- Selecionar personagem ativo
- Listar monstros disponíveis
- Iniciar combate contra monstros
- Usar habilidades durante a batalha
- Ganhar XP ao vencer
- Subir de nível
- Curar personagem ativo
- Remover personagem derrotado

---

## Classes disponíveis

Atualmente o jogo possui três classes principais:

### Warrior

Classe focada em resistência e defesa.

Características:

- Maior quantidade de vida
- Boa defesa
- Ataques físicos consistentes

### Mage

Classe focada em dano mágico.

Características:

- Alto ataque
- Menor defesa
- Habilidades mágicas fortes

### Archer

Classe equilibrada e ofensiva.

Características:

- Bom ataque
- Defesa intermediária
- Habilidades físicas rápidas

---

## Monstros disponíveis

O jogo possui monstros separados por dificuldade:

### Easy

- Slime
- Giant Rat
- Goblin

### Normal

- Orc
- Alpha Wolf
- Bandit

### Hard

- Cave Troll
- Specter

### Impossible

- Ancient Dragon

---

## Sistema de combate

O combate acontece por turnos.

Durante uma batalha:

1. O jogador escolhe uma habilidade.
2. O dano é calculado com base no ataque do jogador, multiplicador da habilidade e defesa do monstro.
3. O monstro recebe o dano.
4. Se o monstro sobreviver, ele contra-ataca.
5. A batalha continua até o jogador ou o monstro ser derrotado.

Ao vencer uma batalha, o jogador recebe XP conforme a dificuldade do monstro.

---

## Sistema de XP

Cada monstro entrega uma quantidade diferente de experiência:

| Dificuldade | XP |
|------------|----|
| Easy | 50 |
| Normal | 100 |
| Hard | 200 |
| Impossible | 500 |

Quando o jogador acumula XP suficiente, ele sobe de nível.

A quantidade necessária para o próximo nível é baseada no nível atual do personagem.

---

## Como rodar o projeto

Clone o repositório:

```bash
git clone https://github.com/Bh0Eri/Rpg.git
```

Entre na pasta do projeto:

```bash
cd Rpg
```

Compile os arquivos Java:

```bash
javac src/*.java
```

Execute o jogo:

```bash
java -cp src Main
```

---

## Estrutura atual do projeto

```txt
Rpg/
├── src/
│   ├── Main.java
│   ├── characters.Character.java
│   ├── characters.Player.java
│   ├── characters.Monster.java
│   ├── Combat.java
│   ├── characters.Skill.java
│   ├── characters.Status.java
│   ├── enums.CharacterClass.java
│   ├── enums.DamageType.java
│   └── enums.Difficulty.java
```

---

## Possíveis melhorias futuras

Algumas melhorias que podem ser adicionadas ao projeto:

- Sistema de inventário
- Sistema de loja
- Itens de cura
- Armas e armaduras
- Defesa durante o turno
- Chance de crítico
- Efeitos reais nas habilidades
- Fraquezas por tipo de dano
- Sistema de moedas
- Salvamento de progresso
- Boss final desbloqueável
- Organização do projeto em packages
- Interface gráfica futuramente

---

## Aprendizados

Este projeto ajuda a praticar conceitos importantes de Java, como:

- Criação de classes
- Herança
- Encapsulamento
- Métodos
- Listas
- Enums
- Interfaces
- Estrutura de menus
- Controle de fluxo
- Organização de lógica de jogo

---

## Autor

Desenvolvido por **Eric Moreira**.

GitHub: [@Bh0Eri](https://github.com/Bh0Eri)

---

## characters.Status do projeto

Projeto em desenvolvimento.

Novas funcionalidades podem ser adicionadas futuramente para transformar o jogo em um RPG mais completo.
