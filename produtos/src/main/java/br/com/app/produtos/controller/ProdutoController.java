package br.com.app.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.produtos.modelo.ProdutoModelo;
import br.com.app.produtos.modelo.RespostaModelo;
import br.com.app.produtos.service.ProdutoServico;

@RestController
@CrossOrigin(origins = "*") //Desbloqueio do Cors
public class ProdutoController {
  
  @Autowired
  private ProdutoServico ps;

  @PostMapping("/cadastrar")
  public ResponseEntity<?>cadastrar(@RequestBody ProdutoModelo pm){
    return ps.cadastrarAlterar(pm, "cadastrar");
  }

  @PutMapping("/alterar")
  public ResponseEntity<?>alterar(@RequestBody ProdutoModelo pm){
    return ps.cadastrarAlterar(pm, "alterar");
  }

  @DeleteMapping("/remover/{codigo}")
  public ResponseEntity<RespostaModelo> remover(@PathVariable Long codigo){
    return ps.remover(codigo);
  }

  @GetMapping("/listar")
  public Iterable<ProdutoModelo> listar(){
    return ps.listar();
  }

  @GetMapping("/")
  public String rota(){
    return "API de produtos funcionando";
  }

}
