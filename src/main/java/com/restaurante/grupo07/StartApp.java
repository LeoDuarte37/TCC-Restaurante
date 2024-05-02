package com.restaurante.grupo07;

import com.restaurante.grupo07.enumeration.StatusPedido;
import com.restaurante.grupo07.model.*;
import com.restaurante.grupo07.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private MesaRepository mesaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private PedidoRepository pedidoRepository;


    @Override
    public void run(String... args) throws Exception {
        Endereco end = new Endereco();
        end.setRua("Av General");
        end.setBairro("Jardim São Jorge");
        end.setCidade("São Paulo");
        end.setUf("SP");
        enderecoRepository.save(end);

        Contato cont = new Contato();
        cont.setEmail("leonardo123@gmail.com");
        cont.setTelefone("11993571891");
        contatoRepository.save(cont);

        Restaurante res = new Restaurante();
        res.setNome("Restaurante do seu Zé");
        res.setCnpj("01.234.567/0001-10");
        res.setContato(cont);
        res.setEndereco(end);
        restauranteRepository.save(res);

        Mesa mesa = new Mesa();
        mesa.setNumero(1L);
        mesa.setRestaurante(res);
        mesaRepository.save(mesa);

        Categoria categ = new Categoria();
        categ.setNome("Comida");
        categ.setDisponivel(true);
        categ.setFoto("Foto.png");
        categoriaRepository.save(categ);

        Produto prod = new Produto();
        prod.setNome("Arroz");
        prod.setDescricao("Arroz integral");
        prod.setFoto("Arroz.png");
        prod.setValor(20);
        prod.setDisponivel(true);
        prod.setCategoria(categ);
        produtoRepository.save(prod);

        Item item = new Item();
        item.setProduto(prod);
        item.setQuantidade(2);

        List<Item> itemList = new ArrayList<Item>(Arrays.asList(item));

        float total = item.getProduto().getValor() * item.getQuantidade();

        Pedido pedido = new Pedido();
        pedido.setMesa(mesa);
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setItem(itemList);
        pedido.setTotal(total);
        pedidoRepository.save(pedido);

        item.setPedido(pedido);
        itemRepository.save(item);

//
//        for (Object[] p : pedidoRepository.findAllByMesa(1L)) {
//            System.out.println(p);
//        }
//
//        for (Pedido p : pedidoRepository.findAllByStatusOrderByDataDesc(StatusPedido.doStatus("R"))) {
//            System.out.println(p.getId());
//            System.out.println(p.getItem());
//            System.out.println(p.getStatus());
//            System.out.println(p.getMesa().getNumero());
//            System.out.println(p.getTotal());
//            System.out.println(p.getData());
//        }
    }
}
