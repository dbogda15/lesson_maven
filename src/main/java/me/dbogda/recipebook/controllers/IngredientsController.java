package me.dbogda.recipebook.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dbogda.recipebook.model.Ingredient;
import me.dbogda.recipebook.service.IngredientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ingredients")
@Tag(name = "Редактор ингридиентов", description = "Приложение для добавления и редактирования ингридиентов")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    public IngredientsController (IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping("/add")
    @Operation(summary = "Добавление нового ингридиента")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Новый ингридиент добавлен"
            )
    })
    public ResponseEntity<Integer> addIngredients (@RequestBody Ingredient ingredient) {
        int id = ingredientsService.putIngredients(ingredient);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Распечатать ингридиент по id")
    @Parameters(value = {
            @Parameter(name = "id", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингридиент с данным id найден",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
                            )
                    }
            )
    })
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable int id) {
        Ingredient ingredient = ingredientsService.getIngredientByID(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
    @DeleteMapping ("/delete/{id}")
    @Operation(summary = "Удалить ингридиент по id")
    @Parameters(value = {
            @Parameter(name = "id", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингридиент с данным id удалён"
            )
    })
    public ResponseEntity<String> deleteIngredientById(@PathVariable int id) {
        String message = ingredientsService.deleteIngredient(id);
        if (message == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Редактировать ингридиент по id")
    @Parameters(value = {
            @Parameter(name = "id", example = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингридиент с данным id изменён",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
                            )
                    }
            )
    })
    public ResponseEntity <Ingredient> editIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        Ingredient editIngredient = ingredientsService.editIngredient(id, ingredient);
        if (editIngredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editIngredient);
    }

    @GetMapping("/print")
    @Operation(summary = "Распечатать все ингридиенты")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Все ингридиенты найдены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
                            )
                    }
            )
    })
    public ResponseEntity<Map<Integer, Ingredient>> getAllIngredients () {
        Map<Integer, Ingredient> allIngredientsMap = ingredientsService.getAllIngredients();
        if (allIngredientsMap.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allIngredientsMap);
    }

}
