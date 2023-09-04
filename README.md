# API dos Chefes (Robot Masters) do Megaman

Um servidor Nodesimples listando os chefes da franquia Megaman.

##Rodando localmente

- Certifique-se de ter o [Node.js](http://nodejs.org) instalado.
- Clone o repositório e execute os seguintes comandos:

```sh
$ npm install
$ npm start
```

Seu aplicativo deve estar rodando agora em [localhost:8000](http://localhost:8000/).

## APIs

### `GET /`

Retorna um array com todos os chefes (Robot Masters):

```json
[
  {
    "id": "009",
    "name": "Metal Man",
    "weapon": "Metal Blade",
    "avatar": "http://vignette1.wikia.nocookie.net/megaman/images/6/69/Metalmugshot.png",
    ...
  },
  {
    "id": "010",
    "name": "Air Man",
    "weapon": "Air Blade",
    "avatar": "http://vignette1.wikia.nocookie.net/megaman/images/a/af/Airmugshot.png",
    ...
  },
  {
    "id": "011",
    "name": "Bubble Man",
    "weapon": "Bubble Lead",
    "avatar": "http://vignette4.wikia.nocookie.net/megaman/images/5/53/Bubblemugshot.png",
    ...
  },
  ...
]
```

### `GET /byId/<id>`

Retorna um chefe (Robot Master) pelo seu `<id>`

```json
{
  "id": "014",
  "name": "Flash Man",
  "weapon": "Time Stopper",
  "avatar": "http://vignette2.wikia.nocookie.net/megaman/images/3/39/Flashmugshot.png",
  ...
}

```
